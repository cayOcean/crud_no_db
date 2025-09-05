package br.com.aweb.crud_aluno.controller;

import br.com.aweb.crud_aluno.model.Aluno;
import br.com.aweb.crud_aluno.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    // LISTAR TODOS
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.obterTodos());
        return "alunos/listar";
    }

    // FORM CADASTRO
    @GetMapping("/novo")
    public String formularioNovo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/cadastrar";
    }

    // SALVAR NOVO
    @PostMapping("/novo")
    public String salvarNovo(@Valid Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return "alunos/cadastrar";
        }
        service.gravar(aluno);
        return "redirect:/alunos";
    }

    // REMOVER
    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.remover(id);
        return "redirect:/alunos";
    }

    // FORM EDITAR
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        Aluno aluno = service.procurarPorId(id);
        model.addAttribute("aluno", aluno);
        return "alunos/editar";
    }

    // SALVAR EDIÇÃO
    @PostMapping("/editar/{id}")
    public String salvarEdicao(@PathVariable Long id, 
                               @Valid Aluno aluno, 
                               BindingResult result) {
        if (result.hasErrors()) {
            return "alunos/editar";
        }
        aluno.setId(id);
        service.gravar(aluno);
        return "redirect:/alunos";
    }
}
