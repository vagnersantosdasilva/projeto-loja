package com.vss.projetoloja.controller;

import com.vss.projetoloja.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
@RequestMapping("/loja")
public class ProjetoLojaController {

    private ProductRepository productRepository;

    @Autowired
    ProjetoLojaController  (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/produtos")
    public ResponseEntity<?> getProducts () throws Exception {
        ResponseEntity response = new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
        return response;
    }


    @GetMapping("/produtos/imagem/{name}")
    public ResponseEntity<?> getImage (@PathVariable("name") String name) throws Exception{
        String newName = "/images/".concat(name);
        byte[] bytes = Objects.requireNonNull(getClass().getResourceAsStream(newName)).readAllBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        ResponseEntity<?> response = new ResponseEntity<>(bytes,headers,HttpStatus.OK);
        return response;
    }
}
