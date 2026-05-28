package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    @Autowired //Mesma ação de um construtor
    private NinjaRepository ninjaRepository;

    //Listar todos os ninjas
    public List<NinjaModel>listarNinjas(){
        return ninjaRepository.findAll(); //mostrar todos - Extendendo JPA via Repository
    }


}
