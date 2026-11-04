package com.sena.juan.services;


import java.util.List;

import com.sena.juan.dtos.TrabajadorDto;

public interface TrabajadorServices {

    //registrar un nuevo trabajador
    TrabajadorDto guardar(TrabajadorDto trabajadorDto);

    //listar todos los trabajadores
    List<TrabajadorDto> listarTodos();

    //Consultar trabajador por id
    TrabajadorDto buscarPorId(Long id);
    
    //actualizar trabajador
    TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto);

    //eliminar trabajador
    TrabajadorDto eliminar(Long id);

    



}
