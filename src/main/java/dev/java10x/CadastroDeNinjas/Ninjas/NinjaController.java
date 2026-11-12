package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Criando sozinho meu Controller.";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com Sucesso! \nNome: " + novoNinja.getNome() + "\n ID: " + novoNinja.getId());
    }

    // Mostrar ninjas Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> listarNinjas  = ninjaService.listarNinjas();
        return ResponseEntity.ok(listarNinjas);
    }

    // Mostrar ninjas por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listaNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjasPorId(id);
        if(ninjaDTO != null){
            return ResponseEntity.ok(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id de ninja não encontrado. Digite um Id válido!");
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID/{id}")
    public ResponseEntity<String> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.atualizaNinja(id, ninjaAtualizado) != null) {
            ninjaService.atualizaNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("Ninja do ID " + id + " foi atualizado com novas informações.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja do ID " + id + " não foi encontrado. Por favor digite o ID de um ninja Válido!");
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarId/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com ID o " + id + " não foi encontrado. Digite um ID válido!");
        }
    }
}
