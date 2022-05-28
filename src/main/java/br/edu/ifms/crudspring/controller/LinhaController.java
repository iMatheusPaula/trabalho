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

import br.edu.ifms.crudspring.model.Linha;
import br.edu.ifms.crudspring.services.LinhaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/linha")
@Slf4j
public class LinhaController {

    @Autowired
    LinhaService linhaService;

    @PostMapping("/") //salvar
    public String save(@ModelAttribute("linha") Linha linha){
        LinhaService.save(linha);
        return "redirect:/linha/";
    }
   
   /* @GetMapping("/")
    public String listLinha(Model model){
        log.info("listando linhas...");
        List<Linha> linha = linhaService.getLinha();
        model.addAttribute("linha", linha);
        return "list-linha";
    } */

    @GetMapping("/") //pegar todos 
    public String getAll(Model model){
        List<Linha> linha = linhaService.getLinha();  
        model.addAttribute("linha", linha);
        return "index.html";
    }
   
    @GetMapping("/cadastrar") //criar novo 
    public String newLinha(Model model){
        model.addAttribute("linha", new LinhaController());
        return "cadastrar-linha.html";
    }
    
    @GetMapping("/remove/{id}") //apagar pelo id
    public String removeLinha(@PathVariable("id") UUID id){
        log.info("id =" + id);
        linhaService.delete(id);
        return "redirect:/linha/";
    }


    @GetMapping("/edit/{id}") //editar pelo id
    public Linha editLinha(@PathVariable("id") UUID id, Model model){
        Linha linha = linhaService.findById(id);
        return linha;
    }
   
    // update
    @PostMapping("/update/{id}")
    public String updateLinha(@PathVariable("id") UUID id, @ModelAttribute Linha linha, Model model){

        linhaService.updateLinha(linha);

        return "redirect:/linha/";
    }
    
}
