package br.edu.ifms.crudspring.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Passageiro {

    @Id //passageiro_id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String cpf;
    int passagem;
    int quantidade;

    //onibus
    @OneToMany(mappedBy = "passageiro", 
    fetch = FetchType.LAZY,cascade = {CascadeType.DETACH})
    private Set<Onibus> onibus;    
    
    /* @OneToMany(mappedBy = "onibus")    
    List<Onibus> onibus = new ArrayList<Onibus>(); */
   
}
