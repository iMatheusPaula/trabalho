package br.edu.ifms.crudspring.model;
import java.util.UUID;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Onibus {

    @Id //onibus_id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    UUID id;
    
    int numero;
    int quantidade; 
    String placa;

    @OneToOne (cascade = {CascadeType.DETACH}) //Motorista
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
   
    @ManyToOne (optional = true) //Passageiro
    @JoinColumn(name = "passageiro_id", 
    referencedColumnName = "quantidade", nullable = true)
    private Passageiro passageiro;
    
    @ManyToMany //Linha
    @JoinTable (
    name = "linha_onibus",
    joinColumns = @JoinColumn(
        name="quantidade_onibus", 
        referencedColumnName = "quantidade",
        nullable = true
    ),
    inverseJoinColumns = @JoinColumn(
        name="quantidade_linha",
        referencedColumnName = "quantidade",
        nullable = true
    )
    ) private Set<Linha> linha;
    
    /*
    @ManyToMany(cascade = CascadeType.ALL) //Linha
    @JoinTable (
    name = "linha_onibus",
    joinColumns = {
        @JoinColumn(name="onibus_id")},
        inverseJoinColumns = {@JoinColumn(name = "linha_id")}
    ) private List<Linha> linha;
        */

}
