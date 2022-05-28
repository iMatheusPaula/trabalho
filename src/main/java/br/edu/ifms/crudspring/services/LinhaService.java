package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Linha;
import br.edu.ifms.crudspring.repository.LinhaRepository;

@Service
public class LinhaService {

    @Autowired
    static
    LinhaRepository linhaRepository;

    public LinhaService(){

    }

    public List<Linha> getLinha(){
        return linhaRepository.findAll();
    }

    public static void save(Linha linha){
        linhaRepository.save(linha);
    }

    public void delete(UUID id){
        linhaRepository.deleteById(id);
    }


    public Linha findById(UUID id) {
        return linhaRepository.findById(id).get();
    }
    
    public void updateLinha(Linha linha){
        linhaRepository.save(linha);
    }
    
}
