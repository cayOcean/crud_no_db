package br.com.aweb.crud_aluno.service;

import br.com.aweb.crud_aluno.model.Aluno;
import br.com.aweb.crud_aluno.repository.AlunoDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoDAO dao;

    public AlunoService(AlunoDAO dao) {
        this.dao = dao;
    }

    public Aluno procurarPorId(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Aluno> obterTodos() {
        return dao.findAll();
    }

    public void gravar(Aluno aluno) {
        dao.save(aluno);
    }

    public void remover(Long id) {
        dao.deleteById(id);
    }
}
