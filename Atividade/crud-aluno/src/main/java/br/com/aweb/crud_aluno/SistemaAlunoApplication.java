package br.com.aweb.crud_aluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaAlunoApplication {

    public static void main(String[] parametros) {
        SpringApplication.run(SistemaAlunoApplication.class, parametros);
        System.out.println("Sistema de Alunos iniciado com sucesso!");
    }
}
