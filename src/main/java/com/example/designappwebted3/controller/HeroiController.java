package com.example.designappwebted3.controller;

import com.example.designappwebted3.model.dto.HeroiDTO;
import com.example.designappwebted3.model.view.HeroiView;
import com.example.designappwebted3.service.HeroiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/heroi")
public class HeroiController {

    private final HeroiService service;

    public HeroiController(HeroiService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<HeroiView>> listarHerois(){
        var response = this.service.listarHerois();
        if(response != null){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        var response = this.service.listarPorId(id);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<HeroiDTO> cadastrarHeroi(@RequestBody HeroiDTO heroiDTO ) {
        this.service.cadastrarHeroi(heroiDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(heroiDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
            this.service.deletarHeroi(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> atualizarHeroi(@PathVariable Long id, @RequestBody HeroiDTO heroiDTO){
        this.service.atualizar(id, heroiDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
