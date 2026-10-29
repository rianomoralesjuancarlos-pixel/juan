package com.sena.juan.servicesimplement;

import org.springframework.stereotype.Service;

import com.sena.juan.dtos.UsuarioDto;
import com.sena.juan.mappers.UsuarioMapper;
import com.sena.juan.models.usuarios.Usuario;
import com.sena.juan.repositoryes.UsuarioRepository;
import com.sena.juan.services.UsuarioServices;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 


public class UsuarioServicesImplement implements UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override 
    public UsuarioDto guardar(UsuarioDto usuarioDto){
    Usuario usuario = usuarioMapper.convierteaEntidad(usuarioDto);

    Usuario Usuarioguardado = usuarioRepository.save(usuario);

    return usuarioMapper.ConvierteaDto(Usuarioguardado);


    }
}

