package com.sena.juan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.juan.dtos.UsuarioDto;
import com.sena.juan.models.usuarios.Usuario;

@Mapper (componentModel = "string")
public interface UsuarioMapper {

    //convertir Entidad a Dto
    @Mapping (source = "nom" , target = "nomb")
    @Mapping (source = "ape" , target = "apell")
    @Mapping (source = "dir" , target = "direc")
    @Mapping (source = "tel" , target = "tele")
    UsuarioDto ConvierteaDto(Usuario usuario);

    //convertir Dto a Entidad
    @Mapping (source = "nomb" , target = "nom")
    @Mapping (source = "apell" , target = "ape")
    @Mapping (source = "direc" , target = "dir")
    @Mapping (source = "tele" , target = "tel")
    Usuario convierteaEntidad(UsuarioDto usuario);
}
