package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";  // Tem que retornar o nome da pagina que renderiza
    }

    // Mostrar ninjas por ID (READ)
    @GetMapping("/listar/{id}")
    public String listaNinjasPorId(@PathVariable Long id, Model modelNinja) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjasPorId(id);
        if (ninjaDTO != null) {
            modelNinja.addAttribute("ninja", ninjaDTO);
            return "detalhesNinja";
        } else {
            modelNinja.addAttribute("mensagem", "Ninja não encontrado!");
            return "listarNinjas";
        }
    }

    @PostMapping("/alterarID/{id}")
    public String alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaAtualizado != null) {
            ninjaService.atualizaNinja(id, ninjaAtualizado);
            return "redirect:/ninjas/ui/listar";
        } else {
            System.out.println("Ninja criado está vazio! Por favor, preencha os dados de cadastro do Ninja.");
            return "ninjas/ui/alterarID/{id}";
        }
    }

    // Deletar Ninja (DELETE)
    @GetMapping("/deletarId/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }
}
