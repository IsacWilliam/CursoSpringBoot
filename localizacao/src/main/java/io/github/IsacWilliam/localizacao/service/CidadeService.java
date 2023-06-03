package io.github.IsacWilliam.localizacao.service;

import io.github.IsacWilliam.localizacao.domain.entity.Cidade;
import io.github.IsacWilliam.localizacao.domain.repository.CidadeRepository;
import static io.github.IsacWilliam.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CidadeService {
    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    @Transactional
    void salvarCidade(){
        var cidade = new Cidade(1L, "Sao Paulo", 12396372L);
        repository.save(cidade);
    }

    public void listarCidadesPorQuantidadeHabitantes(){
        repository
                .findByHabitantesLessThanAndNomeLike(1000001L, "Br%")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNomeSQL(){
        repository
                .findByNomeSqlNativo("São Paulo")
                .stream().map(cidadeProjection ->
                        new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(), null))
                .forEach(System.out::println);
    }

    public void listarCidadesPorNome(){
        Pageable pageable = PageRequest.of(2, 2, Sort.by("habitantes"));
        repository
                .findByNomeLike("%", pageable)
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(){
        repository.findByHabitantes(78787900L).forEach(System.out::println);
    }

    void listarCidades(){
        repository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){

        ExampleMatcher matcher = ExampleMatcher.
                matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){
        repository.findAll(nomeEqual("São Paulo")
                .and(idEqual(1L)))
                .forEach(System.out::println);
    }

    public void listarCidadesSpecFiltroDinamico(Cidade filtro){
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if (filtro.getId() != null){
            specs = specs.and(idEqual(filtro.getId()));
        }

        if (StringUtils.hasText(filtro.getNome())){
            specs = specs.and(nomeLike(filtro.getNome()));
        }

        if (filtro.getHabitantes() != null){
            specs = specs.and(habitantesGreaterThan(Math.toIntExact(filtro.getHabitantes())));
        }

        repository.findAll(specs).forEach(System.out::println);
    }

}
