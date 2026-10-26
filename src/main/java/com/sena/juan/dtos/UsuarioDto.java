package com.sena.juan.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class UsuarioDto {

    private Long id;
    private String nomb;
    private String apell;
    private String direc;
    private long tele;

}
