package com.sena.juan.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.juan.dtos.UsuarioDto;
import com.sena.juan.services.UsuarioServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("api/usuarios")
@RequiredArgsConstructor 

public class UsuarioController {

    private final UsuarioServices usuarioServices;

    //1 Registrar nuevo usuario
    @PostMapping
    public ResponseEntity <UsuarioDto> guardar(@Valid @RequestBody UsuarioDto usuarioDto) {
        
        UsuarioDto usuarioguardado = usuarioServices.guardar(usuarioDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(usuarioguardado)
        ;
    }
}