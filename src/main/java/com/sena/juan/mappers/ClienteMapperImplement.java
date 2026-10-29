package com.sena.juan.mappers;

import org.springframework.stereotype.Component;

import com.sena.juan.dtos.ClienteDto;
import com.sena.juan.models.usuarios.Cliente;
@Component
public class ClienteMapperImplement implements ClienteMapper{

    @Override
    public ClienteDto toDto(Cliente cliente){
        
        //Valida que tenga datos
        if (cliente == null) {
            return null;
        }

        //Convertir dde Cliente a ClienteDto
        return ClienteDto.builder()

        //Atributos de Usuario
        .id(cliente.getId())
        .nomb(cliente.getNom())
        .apell(cliente.getApe())
        .direc(cliente.getDir())

        //Atributos de Cliente
        .tipCli(cliente.getTipoCliente())
        .pts(cliente.getPuntos())
        .build();
    
    }

    @Override
    public Cliente toCliente(ClienteDto clienteDto) {

    //Valida que tenga datos
        if (clienteDto == null) {
            return null;
        }

        return Cliente.builder()
        //Atributos de usuarioDto
        .id(clienteDto.getId())
        .nom(clienteDto.getNomb())
        .ape(clienteDto.getApell())
        .tel(clienteDto.getTele())

        .tipoCliente(clienteDto.getTipCli())
        .puntos(clienteDto.getPts())
        .build();
}
    }