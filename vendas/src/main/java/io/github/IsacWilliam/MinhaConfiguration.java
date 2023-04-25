package io.github.IsacWilliam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }
    @Bean(name = "outraConfiguração")
    public String outraConfiguracao(){
        return "Sitema de Vendas";
    }
}
