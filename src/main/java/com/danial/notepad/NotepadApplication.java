package com.danial.notepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotepadApplication {

    public static void main(String[] args) {

        SpringApplication.run(NotepadApplication.class, args);
    }

}
