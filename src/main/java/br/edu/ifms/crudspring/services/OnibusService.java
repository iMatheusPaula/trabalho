package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Onibus;
import br.edu.ifms.crudspring.repository.OnibusRepository;

@Service

public class OnibusService {

    @Autowired
    static
    OnibusRepository onibusRepository;

    public OnibusService() {
    }

    public List<Onibus> getOnibus(){
        return onibusRepository.findAll();
    }

    public static void save(Onibus onibus){
        onibusRepository.save(onibus);
    }

    public void delete(UUID id){
        onibusRepository.deleteById(id);
    }

    public Onibus findById(UUID id) {
        return onibusRepository.findById(id).get();
    }
    
    public void updateOnibus(Onibus onibus){
        onibusRepository.save(onibus);
    }

    
}
