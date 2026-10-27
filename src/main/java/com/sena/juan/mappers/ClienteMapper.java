package com.sena.juan.mappers;

import com.sena.juan.dtos.ClienteDto;
import com.sena.juan.models.usuarios.Cliente;

public interface ClienteMapper {

    //De Cliente a ClienteDto
    ClienteDto toDto (Cliente cliente);

    //De CLienteDto a Cliente
    Cliente toEntity (ClienteDto clienteDto);

    

}
