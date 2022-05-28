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

import br.edu.ifms.crudspring.model.Onibus;
import br.edu.ifms.crudspring.services.OnibusService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/onibus")
@Slf4j
public class OnibusController {

    @Autowired
    OnibusService onibusService;

    @PostMapping("/") //salvar
    public String save(@ModelAttribute("onibus") Onibus onibus){
        OnibusService.save(onibus);
        return "redirect:/onibus/";
    }
   
   /* @GetMapping("/")
    public String listOnibus(Model model){
        log.info("listando onibus...");
        List<Onibus> onibus = onibusService.getOnibus();
        model.addAttribute("onibus", onibus);
        return "list-onibus";
    } */

    @GetMapping("/") //pegar todos os ônibus
    public String getAll(Model model){
        List<Onibus> onibus = onibusService.getOnibus();  
        model.addAttribute("onibus", onibus);
        return "index.html";
    }
   
    @GetMapping("/cadastrar") //criar novo onibus
    public String newOnibus(Model model){
        model.addAttribute("onibus", new OnibusController());
        return "cadastrar-onibus.html";
    }
    
    @GetMapping("/remove/{id}") //apagar onibus pelo id
    public String removeOnibus(@PathVariable("id") UUID id){
        log.info("id =" + id);
        onibusService.delete(id);
        return "redirect:/onibus/";
    }


    @GetMapping("/edit/{id}") //editar onibus pelo id
    public Onibus editOnibus(@PathVariable("id") UUID id, Model model){
        Onibus onibus = onibusService.findById(id);
        return onibus;
    }
   
    // update
    @PostMapping("/update/{id}")
    public String updateOnibus(@PathVariable("id") UUID id, @ModelAttribute Onibus onibus, Model model){

        
        onibusService.updateOnibus(onibus);

        return "redirect:/onibus/";
    }

}
