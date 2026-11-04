package com.sena.juan.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.juan.dtos.TrabajadorDto;

import com.sena.juan.models.usuarios.Trabajador;

@Mapper (componentModel = "spring")
public interface TrabajadorMapper {

    //Convierte de Entidad a Dto
    //Trabajador a trabajadorDto
    @Mapping (source = "nomb" , target = "nom")
    @Mapping (source = "apell" , target = "ape")
    @Mapping (source = "direc" , target = "dir")
    @Mapping (source = "tele" , target = "tel")
    @Mapping (source = "salario" , target = "sueldo")
    Trabajador toEntidad(TrabajadorDto trabajadorDto);

     //convertir Dto a Entidad
    @Mapping (source = "nom" , target = "nomb")
    @Mapping (source = "ape" , target = "apell")
    @Mapping (source = "dir" , target = "direc")
    @Mapping (source = "tel" , target = "tele")
    @Mapping (source = "sueldo" , target = "salario")
    TrabajadorDto toDto(Trabajador trabajador);
}