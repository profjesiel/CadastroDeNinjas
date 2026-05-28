package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/mensagem")
    public String boasVindas(){
        return "Primeira mensagem dessa rota!";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar Ninja por ID (READ) - {id} variável do caminho
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPoriId(@PathVariable Long id){
        return ninjaService.listarNinjasPoriId(id);
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Alterar Ninja por ID";
    }

    //Deletar Ninja (DELETE) - PathVariable toda vez que eu quiser passar o que o usuário e passar pela url
    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorID(id);
        return "Ninja deletado com sucesso!";
    }
}
