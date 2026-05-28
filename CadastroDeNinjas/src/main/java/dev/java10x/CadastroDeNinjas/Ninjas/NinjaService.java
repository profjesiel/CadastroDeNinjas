package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired //Mesma ação de um construtor
    private NinjaRepository ninjaRepository;

    //Listar todos os ninjas
    public List<NinjaModel>listarNinjas(){
        return ninjaRepository.findAll(); //mostrar todos - Extendendo JPA via Repository
    }

    //Listar todos os ninjas por ID
    public NinjaModel listarNinjasPoriId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    /*Deletar Ninja - tem que ser um void */
    public void deletarNinjaPorID(Long id){
        ninjaRepository.deleteById(id);
    }

}
