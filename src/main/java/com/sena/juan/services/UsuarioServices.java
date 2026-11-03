package com.sena.juan.services;

import java.util.List;

import com.sena.juan.dtos.UsuarioDto;

public interface UsuarioServices {

    //registrar un nuevo usuario
    UsuarioDto guardar(UsuarioDto usuarioDto);

    //listar todos los usuario
    List<UsuarioDto> ListarTodos();

    //Consultar usuario por id
    UsuarioDto buscarPorId(Long id);

    //Actualizar usuario
    UsuarioDto actualizar(Long id, UsuarioDto usuarioDto);
    //Eliminar usuario
    UsuarioDto eliminar(Long id);




}
