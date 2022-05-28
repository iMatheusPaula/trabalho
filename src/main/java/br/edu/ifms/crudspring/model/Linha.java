package br.edu.ifms.crudspring.model;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Linha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    int quantidade;
    String horario;

    //onibus
    @ManyToMany (mappedBy = "linha")
    private Set<Onibus> onibus; 

    /*
    @ManyToMany (mappedBy = "linha")  
    List<Linha> linha = new ArrayList<Linha>(); 
    */
}
