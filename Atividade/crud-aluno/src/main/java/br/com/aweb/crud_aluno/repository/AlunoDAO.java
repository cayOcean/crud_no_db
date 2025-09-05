package br.com.aweb.crud_aluno.repository;

import br.com.aweb.crud_aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Long> {

    // Exemplo de consulta adicional (não obrigatória)
    Aluno findByEmail(String email);
}
