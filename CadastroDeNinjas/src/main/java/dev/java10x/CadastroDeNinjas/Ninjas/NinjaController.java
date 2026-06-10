package dev.java10x.CadastroDeNinjas.Ninjas;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: " + novoNinja.getNome() + " ID: " +novoNinja.getId());
    }

    //Mostrar Ninja por ID (READ) - {id} variável do caminho
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPoriId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPoriId(id);
        if(ninja!=null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " +id+ " não encontrado");
        }
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Alterar dados dos Ninjas (UPDATE) - @RequestBody para atualizar a parte do corpo
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if(ninja!=null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: "+ id +" não encontrado");
        }
    }

    //Deletar Ninja (DELETE) - PathVariable toda vez que eu quiser passar o que o usuário e passar pela url
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        if(ninjaService.listarNinjasPoriId(id)!=null){
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " +id+ " não encontrado");
        }
    }
}
