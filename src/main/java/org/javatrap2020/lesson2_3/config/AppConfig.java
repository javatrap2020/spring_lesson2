package org.javatrap2020.lesson2_3.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;


@Configuration
@ComponentScan(basePackages = "org.javatrap2020.lesson2_3.model")
public class AppConfig {
    static String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=~~&json";
    @Bean
    HttpClient httpClient(){
        return HttpClient
                .newBuilder()
                .build();
    }

    @Bean
    //@Primary
    HttpRequest requestUsd(){
        //var url2 = url.replace("~~", "USD");
        return HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .GET()
                .uri(URI.create(url.replace("~~", "USD")))
                .build();


    }

    @Bean
    HttpRequest requestEur(){

        return HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .GET()
                .uri(URI.create(url.replace("~~","EUR")))
                .build();
    }

    @Bean
    @Primary
    HttpRequest requestPln(){

        return HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .GET()
                .uri(URI.create(url.replace("~~", "Pln")))
                .build();
    }

}
