package com.braulio.demoajax.web.controller;

import com.braulio.demoajax.domain.Categoria;
import com.braulio.demoajax.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @ModelAttribute("categorias")
    public List<Categoria> getCategoria(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/add")
    public String abrirCadastro(){

        return "promo-add";
    }
}
