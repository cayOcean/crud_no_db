package br.com.aweb.crud_aluno.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome não pode ficar vazio")
    private String nomeCompleto;

    @NotBlank(message = "Informe um e-mail válido")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @Min(value = 1, message = "A idade precisa ser positiva")
    private int anos;

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnos() {
        return anos;
    }
    public void setAnos(int anos) {
        this.anos = anos;
    }
}
