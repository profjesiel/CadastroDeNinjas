package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

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
    @GetMapping("/todosID")
    public String mostrarTodosNinjasPorID(){
        return "Mostrar Ninja po ID";
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosNinjas(){
        return "Ninja Criado";
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
