package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Passageiro;
import br.edu.ifms.crudspring.repository.PassageiroRepository;

@Service
public class PassageiroService {

    @Autowired
    static
    PassageiroRepository passageiroRepository;

    public PassageiroService(){

    }

    public List<Passageiro> getPassageiro(){
        return passageiroRepository.findAll();
    }

    public static void save(Passageiro passageiro){
        passageiroRepository.save(passageiro);
    }

    public void delete(UUID id){
        passageiroRepository.deleteById(id);
    }


    public Passageiro findById(UUID id) {
        return passageiroRepository.findById(id).get();
    }
    
    public void updatePassageiro(Passageiro passageiro){
        passageiroRepository.save(passageiro);
    }
    
}
