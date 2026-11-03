package com.sena.juan.servicesimplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.juan.dtos.UsuarioDto;
import com.sena.juan.mappers.UsuarioMapper;
import com.sena.juan.models.usuarios.Usuario;
import com.sena.juan.repositoryes.UsuarioRepository;
import com.sena.juan.services.UsuarioServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 


public class UsuarioServicesImplement implements UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override 
    public UsuarioDto guardar(UsuarioDto usuarioDto){
    Usuario usuario = usuarioMapper.ConvierteaEntidad(usuarioDto);

    Usuario Usuarioguardado = usuarioRepository.save(usuario);

    return usuarioMapper.ConvierteaDto(Usuarioguardado);


    }

    @Override 
    public List<UsuarioDto>ListarTodos(){
        return usuarioRepository.findAll()
        .stream()
        .map(usuarioMapper::ConvierteaDto)
        .toList();
    }

    @Override 
    public UsuarioDto buscarPorId (Long id){
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() ->new EntityNotFoundException("usuario no encontrado"+id)
    );
    
        return usuarioMapper.ConvierteaDto(usuario);

    } 




    
}

