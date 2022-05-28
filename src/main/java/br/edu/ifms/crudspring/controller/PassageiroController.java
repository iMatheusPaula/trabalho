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

import br.edu.ifms.crudspring.model.Passageiro;
import br.edu.ifms.crudspring.services.PassageiroService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/passageiro")
@Slf4j
public class PassageiroController {

    @Autowired
    PassageiroService passageiroService;

    @PostMapping("/") //salvar
    public String save(@ModelAttribute("passageiro") Passageiro passageiro){
        PassageiroService.save(passageiro);
        return "redirect:/passageiro/";
    }
   
   /* @GetMapping("/")
    public String listPassageiro(Model model){
        log.info("listando passageiro...");
        List<Passageiro> passageiro = passageiroService.getPassageiro();
        model.addAttribute("passageiro", passageiro);
        return "list-passageiro";
    } */

    @GetMapping("/") //pegar todos 
    public String getAll(Model model){
        List<Passageiro> passageiro = passageiroService.getPassageiro();  
        model.addAttribute("passageiro", passageiro);
        return "index.html";
    }
   
    @GetMapping("/cadastrar") //criar novo 
    public String newPassageiro(Model model){
        model.addAttribute("passageiro", new PassageiroController());
        return "cadastrar-passageiro.html";
    }
    
    @GetMapping("/remove/{id}") //apagar pelo id
    public String removePassageiro(@PathVariable("id") UUID id){
        log.info("id =" + id);
        passageiroService.delete(id);
        return "redirect:/passageiro/";
    }


    @GetMapping("/edit/{id}") //editar pelo id
    public Passageiro editPassageiro(@PathVariable("id") UUID id, Model model){
        Passageiro passageiro = passageiroService.findById(id);
        return passageiro;
    }
   
    // update
    @PostMapping("/update/{id}")
    public String updatePassageiro(@PathVariable("id") UUID id, @ModelAttribute Passageiro passageiro, Model model){

        
        passageiroService.updatePassageiro(passageiro);

        return "redirect:/passageiro/";
    }
    
    
}
