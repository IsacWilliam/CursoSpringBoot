package io.github.IsacWilliam;

import io.github.IsacWilliam.domain.entity.Cliente;
import io.github.IsacWilliam.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {
        @Bean
        public CommandLineRunner init(@Autowired Clientes clientes){
            return args -> {
                System.out.println("Salvando clientes");
                //Alterar o nome aqui
                clientes.save(new Cliente("Isac"));
                clientes.save(new Cliente("Outro Cliente"));

                boolean existe = clientes.existsByNome("Isac");
                System.out.println("Existe um cliente com o nome Isac? " + existe);
            };
        }

        public static void main(String[] args) {
            SpringApplication.run(VendasApplication.class, args);
        }
    }