package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Motorista;
import br.edu.ifms.crudspring.repository.MotoristaRepository;

@Service
public class MotoristaService {

    @Autowired
    static
    MotoristaRepository motoristaRepository;

    public MotoristaService(){

    }

    public List<Motorista> getMotoristas(){
        return motoristaRepository.findAll();
    }

    public static void save(Motorista motorista){
        motoristaRepository.save(motorista);
    }

    public void delete(UUID id){
        motoristaRepository.deleteById(id);
    }


    public Motorista findById(UUID id) {
        return motoristaRepository.findById(id).get();
    }
    
    public void updateMotorista(Motorista motorista){
        motoristaRepository.save(motorista);
    }

}
