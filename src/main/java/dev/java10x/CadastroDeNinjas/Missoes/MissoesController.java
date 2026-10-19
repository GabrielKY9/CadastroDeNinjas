package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET - Mandar uma requisição para Listar as missões
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas com sucesso!";
    }

    // POST - Mandar uma requisição para Criar as missões
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao Criada com Sucesso!";
    }

    // PUT - Mandar uma requisição para Alterar as missões
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao Alterada com sucesso!";
    }


    // DELETE - Mandar uma requisição para Deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao Deletada com sucesso!";
    }
}
