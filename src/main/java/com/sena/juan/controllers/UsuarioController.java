package com.sena.juan.controllers;

import java.util.List;

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

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






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

    //Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> actualizar(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioServices.actualizar(id, usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }
    //Actualizar usuario por post
    @PostMapping("/actualizar")
    public ResponseEntity <UsuarioDto> actualizarPost(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioServices.actualizar(usuarioDto.getId(), usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }
    //eliminar usuario por id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<UsuarioDto> eliminar(@PathVariable Long id) {
        UsuarioDto usuarioEliminado = usuarioServices.eliminar(id);
        return ResponseEntity.ok(usuarioEliminado);
    }
    //eliminar usuario por delete
    @DeleteMapping("/eliminar")
    public ResponseEntity<UsuarioDto> eliminarPorDelete(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioEliminado = usuarioServices.eliminar(usuarioDto.getId());
        return ResponseEntity.ok(usuarioEliminado); 

    }
}