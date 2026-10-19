package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Criando sozinho meu Controller.";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // Mostrar ninjas Ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Todos os ninjas:";
    }

    // Mostrar ninjas por ID (READ)
    @GetMapping("/todosId")
    public String mostrarTodosOsNinjasPorId(){
        return "Todos os IDs de Ninjas:";
    }

    // Alterar dados dos Ninjas (UPDATE)
   @PutMapping("/alterarID")
   public String alterarNinja(){
       return "Ninja alterado pelo ID!";
   }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Deleta Ninja por ID";
    }
}
