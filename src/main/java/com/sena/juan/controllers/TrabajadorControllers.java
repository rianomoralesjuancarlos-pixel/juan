package com.sena.juan.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.juan.dtos.TrabajadorDto;
import com.sena.juan.services.TrabajadorServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping ("api/trabajadores")
@RequiredArgsConstructor 
public class TrabajadorControllers {

    private final TrabajadorServices trabajadorServices;

    //registrar nuevo trabajador
    @PostMapping
    public ResponseEntity <TrabajadorDto> guardar(@Valid @RequestBody TrabajadorDto trabajadorDto){
        TrabajadorDto trabajadorGuardado = trabajadorServices.guardar(trabajadorDto);
        return ResponseEntity.ok(trabajadorGuardado);
    }

    //listar todos los trabajadores
    @GetMapping
    public ResponseEntity <List<TrabajadorDto>> listarTodos(){
        List<TrabajadorDto> trabajadores = trabajadorServices.listarTodos();
        return ResponseEntity.ok(trabajadores);
    }

    //consultar trabajador por id
    @GetMapping("/{id}")
    public ResponseEntity <TrabajadorDto> buscarPorId(@PathVariable Long id){
        TrabajadorDto trabajador = trabajadorServices.buscarPorId(id);
        return ResponseEntity.ok(trabajador);


    }

    //consultar trabajador por post
    @PostMapping("/buscar")
    public ResponseEntity <TrabajadorDto> buscarPorIdPost(@RequestBody TrabajadorDto trabajadorDto){
        TrabajadorDto trabajador = trabajadorServices.buscarPorId(trabajadorDto.getId());
        return ResponseEntity.ok(trabajador);
    }
    //actualizar trabajador
    @PutMapping("/{id}")
    public ResponseEntity <TrabajadorDto> actualizar(@PathVariable Long id, @Valid @RequestBody TrabajadorDto trabajadorDto){
        TrabajadorDto trabajadorActualizado = trabajadorServices.actualizar(id, trabajadorDto);
        return ResponseEntity.ok(trabajadorActualizado);
    }
    //actualizar por post
    @PostMapping("/actualizar")
    public ResponseEntity <TrabajadorDto> actualizarPorPost(@RequestBody TrabajadorDto trabajadorDto){
        TrabajadorDto trabajadorActualizado = trabajadorServices.actualizar(trabajadorDto.getId(), trabajadorDto);
        return ResponseEntity.ok(trabajadorActualizado);
    }
    //eliminar trabajador
    @DeleteMapping ("/{id}")
    public ResponseEntity <TrabajadorDto> eliminar(@PathVariable Long id){
        TrabajadorDto trabajadorEliminado = trabajadorServices.eliminar(id);
        return ResponseEntity.ok(trabajadorEliminado);


    }
    //eliminar trabajador por delete
    @DeleteMapping("/eliminar")
    public ResponseEntity <TrabajadorDto> eliminarPorDelete(@RequestBody TrabajadorDto trabajadorDto){
        TrabajadorDto trabajadorEliminado = trabajadorServices.eliminar(trabajadorDto.getId());
        return ResponseEntity.ok(trabajadorEliminado);
    }  


}