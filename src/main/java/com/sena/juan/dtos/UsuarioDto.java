package com.sena.juan.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "el nombre es obligatorio")
    @Size (min = 2, max = 60,
        message = "el nombre debe de tener entre 2 y 60 caracteres"
    )

    private String nomb;
    @NotBlank(message = "el apellido es obligatorio")
    @Size (min = 2, max = 60,
        message = "el apellido debe de tener entre 2 y 60 caracteres"

    )
    private String apell;
    @Size (min = 5, max = 120,
        message = "el direccion debe de tener entre 2 y 60 caracteres"
    )

    private String direc;

    @Pattern (regexp = "^{0.9}+$", message = "el campo debe de tener un solo numero")
    private long tele;





}
