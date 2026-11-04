package com.sena.juan.services;

import java.util.List;

import com.sena.juan.dtos.ClienteDto;

public interface ClienteServices {

    ClienteDto guardar(ClienteDto clienteDto);

    //listar todos los clientes
    List<ClienteDto> listarTodos();

    //consultar cliente por id
    ClienteDto buscarPorId(Long id);

    //actualizar cliente
    ClienteDto actualizar(Long id, ClienteDto clienteDto);

    //eliminar cliente
    ClienteDto eliminar(Long id);

}
