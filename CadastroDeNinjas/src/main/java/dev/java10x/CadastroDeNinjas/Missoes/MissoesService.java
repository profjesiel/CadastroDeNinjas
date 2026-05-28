package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {
    private MissoesRepository missoesService ;

    public MissoesService(MissoesRepository missoesService) {
        this.missoesService = missoesService;
    }

    //Listar todos os ninjas
    public List<MissoesModel> listarMissoes(){
        return missoesService.findAll(); //mostrar todos - Extendendo JPA via Repository
    }
}
