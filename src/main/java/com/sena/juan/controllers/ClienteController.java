package com.sena.juan.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.juan.dtos.ClienteDto;
import com.sena.juan.services.ClienteServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping ("api/clientes")
@RequiredArgsConstructor 

public class ClienteController {

    private final ClienteServices clienteServices;

    //1 Registrar nuevo cliente
    @PostMapping
    public ResponseEntity <ClienteDto> guardar(@Valid @RequestBody ClienteDto clienteDto) {
        
        ClienteDto clienteguardado = clienteServices.guardar(clienteDto);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(clienteguardado)
        ;
    }

    //Lista de clientes
    @GetMapping
    public ResponseEntity <List<ClienteDto>> ListarTodos() {
        return ResponseEntity.ok(clienteServices.listarTodos());
    }

    //Consultar por id
    @GetMapping("/{id}")
    public ResponseEntity <ClienteDto> consultarid(@PathVariable Long id) {
        return ResponseEntity.ok(clienteServices.buscarPorId(id));
    }

    //Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity <ClienteDto> actualizar(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteActualizado = clienteServices.actualizar(id, clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }

    //Actualizar por post
    @PostMapping("/actualizar")
    public ResponseEntity <ClienteDto> actualizarPorPost(@RequestBody ClienteDto clienteDto) {
        ClienteDto clienteActualizado = clienteServices.actualizar(clienteDto.getId(), clienteDto);
        return ResponseEntity.ok(clienteActualizado);
    }
    //Eliminar cliente
    @DeleteMapping ("/{id}")
    public ResponseEntity <ClienteDto> eliminar(@PathVariable Long id) {
        ClienteDto clienteEliminado = clienteServices.eliminar(id);
        return ResponseEntity.ok(clienteEliminado);
    }
    //Eliminar cliente por delete
    @DeleteMapping("/eliminar")
    public ResponseEntity<ClienteDto> eliminarPorDelete(@RequestBody ClienteDto clienteDto) {
        ClienteDto clienteEliminado = clienteServices.eliminar(clienteDto.getId());
        return ResponseEntity.ok(clienteEliminado);

}
}