package com.ortiz.jonathan;



import com.ortiz.jonathan.repository.FutbolistaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import java.time.LocalDate;


@SpringBootApplication
public class BackFutbolistasApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackFutbolistasApplication.class, args);
    }


    @Bean
    CommandLineRunner loadData(FutbolistaRepository repository) {
        return args -> {
//            repository.save(new Futbolista("Jonathan", "Ortiz", "2018-02-18", "skill", new Posicion(1L)));
        };
    }
}
