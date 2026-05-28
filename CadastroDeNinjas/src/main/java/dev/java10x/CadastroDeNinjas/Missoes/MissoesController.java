package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    @GetMapping("/missoes")
    public String missoes(){
        return "Mensgem Teste de Missões";

    }
     //Adicionar missão
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    }

    //Alterar Missão
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterar com sucesso";
    }

    //Deletar Missão
    @DeleteMapping("deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

    //Mostrar missão
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Exibir todas as missões";
    }
}
