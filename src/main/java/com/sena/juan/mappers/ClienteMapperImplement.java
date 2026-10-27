package com.sena.juan.mappers;

import org.springframework.stereotype.Component;

import com.sena.juan.dtos.ClienteDto;
import com.sena.juan.models.usuarios.Cliente;

@Component 
public class ClienteMapperImplement {

    @Override 
    private ClienteDto toDto(Cliente cliente){


    //valida que tenga datos
    if (cliente == null)
        return null;

    //convertid de CLiente a CLienteDto
    return ClienteDto.Builder()
    //Atributos de usuario
    .id(cliente.getId())
    .nomb(cliente.getNom())
    .apell(cliente.getApe())
    .direc(cliente.getDir())
    
    //Atributos de clientes
    .tipCli(cliente.getId())
    .pts(cliente.getPuntos())
    .builder();
}
    @Override 
    public Cliente toCliente(ClienteDto clienteDto)
    //validar que tenga datos
    if(clienteDto == null){
        return null;
    }
    return Cliente.Builder ()
    //Atributos de usuarioDto
    .id(clienteDto.getId())
    .nom(clienteDto.getNomb())
    .ape(clienteDto.getApell())
    .tel(clienteDto.getTele())


}


