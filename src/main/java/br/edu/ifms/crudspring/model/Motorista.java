package br.edu.ifms.crudspring.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String nome;
    int cnh;
    int cpf;
    
    //onibus
    @OneToOne (cascade = {CascadeType.DETACH})
    @JoinColumn (name = "onibus_id")
    private Onibus onibus;
    
}
