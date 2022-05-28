package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Motorista;
import br.edu.ifms.crudspring.services.MotoristaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/motorista")
@Slf4j
public class MotoristaController {

   
    @Autowired
    MotoristaService motoristaService;

    @PostMapping("/") //salvar
    public String save(@ModelAttribute("motorista") Motorista motorista){
        MotoristaService.save(motorista);
        return "redirect:/motorista/";
    }
   
   /* @GetMapping("/")
    public String listMotorista(Model model){
        log.info("listando motorista...");
        List<Motorista> motorista = motoristaService.getMotoristas();
        model.addAttribute("motorista", motorista);
        return "list-motorista";
    } */

    @GetMapping("/") //pegar todos 
    public String getAll(Model model){
        List<Motorista> motorista = motoristaService.getMotoristas();  
        model.addAttribute("motorista", motorista);
        return "index.html";
    }
   
    @GetMapping("/cadastrar") //criar novo 
    public String newMotorista(Model model){
        model.addAttribute("motorista", new MotoristaController());
        return "cadastrar-motorista.html";
    }
    
    @GetMapping("/remove/{id}") //apagar pelo id
    public String removeMotorista(@PathVariable("id") UUID id){
        log.info("id =" + id);
        motoristaService.delete(id);
        return "redirect:/motorista/";
    }


    @GetMapping("/edit/{id}") //editar pelo id
    public Motorista editMotorista(@PathVariable("id") UUID id, Model model){
        Motorista motorista = motoristaService.findById(id);
        return motorista;
    }
   
    // update
    @PostMapping("/update/{id}")
    public String updateMotorista(@PathVariable("id") UUID id, @ModelAttribute Motorista motorista, Model model){
        motoristaService.updateMotorista(motorista);
        return "redirect:/motorista/";
    }
    
}
