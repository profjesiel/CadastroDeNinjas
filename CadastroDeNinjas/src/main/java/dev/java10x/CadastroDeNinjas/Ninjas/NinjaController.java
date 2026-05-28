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
    public String criarNinja(){
        return "Mostrar Ninja";
    }

    //Mostrar Ninja por ID (READ)
    @GetMapping("/listarPorID")
    public String mostrarTodosNinjasPorID(){
        return "Mostrar Ninja po ID";
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

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarPorID")
    public String deletarNinjaPorID(){
        return "Deletado Ninja por ID";
    }
}
