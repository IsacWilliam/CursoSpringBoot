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
                clientes.save(new Cliente("Fulano"));
                clientes.save(new Cliente("Outro Cliente"));

                List<Cliente> result = clientes.encontrarPorNome("Isac");
                result.forEach(System.out::println);
            };
        }

        public static void main(String[] args) {
            SpringApplication.run(VendasApplication.class, args);
        }
    }