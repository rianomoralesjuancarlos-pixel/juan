package com.sena.juan.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.juan.dtos.UsuarioDto;
import com.sena.juan.models.usuarios.Usuario;
import com.sena.juan.services.UsuarioServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





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

    //Lista de usuario
    @GetMapping
    public ResponseEntity <List<UsuarioDto>> ListarTodos() {
        return ResponseEntity.ok(usuarioServices.ListarTodos());
    }

    //COnsultar por id
    @GetMapping("/{id}")
    public ResponseEntity <UsuarioDto> consultarid(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServices.buscarPorId(id));
    }
    //Consultar por post
    @PostMapping("/buscar")
    public ResponseEntity<UsuarioDto> consultaIdPost(@RequestBody UsuarioDto Dto) {
        UsuarioDto encontrado = usuarioServices.buscarPorId(Dto.getId());
        return ResponseEntity.ok(encontrado);
    }
    
    


}