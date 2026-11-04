package com.sena.juan.servicesimplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.juan.dtos.TrabajadorDto;
import com.sena.juan.mappers.TrabajadorMapper;
import com.sena.juan.models.usuarios.Trabajador;
import com.sena.juan.repositoryes.TrabajadorRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TrabajadorServicesImplement {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;

    public TrabajadorDto guardar(TrabajadorDto trabajadorDto){
        Trabajador trabajador = trabajadorMapper.toEntidad(trabajadorDto);  

        Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador);

        return trabajadorMapper.toDto(trabajadorGuardado);
    }

    //listar todos los trabajadores
    public List<TrabajadorDto> listarTodos(){
        return trabajadorRepository.findAll()
        .stream()
        .map(trabajadorMapper::toDto)
        .toList();
}

    //consultar trabajador por id
    public TrabajadorDto buscarPorId(Long id){
        Trabajador trabajador = trabajadorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " +id));
        return trabajadorMapper.toDto(trabajador);
    }

    //actualizar trabajador
    public TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto) {
        Trabajador trabajadorEncontrado = trabajadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));

        trabajadorEncontrado.setNom(trabajadorDto.getNomb());
        trabajadorEncontrado.setApe(trabajadorDto.getApell());
        trabajadorEncontrado.setCargo(trabajadorDto.getCargo());

        Trabajador trabajadorActualizado = trabajadorRepository.save(trabajadorEncontrado);

        return trabajadorMapper.toDto(trabajadorActualizado);
    }
    //eliminar trabajador
    public TrabajadorDto eliminar(Long id){
        Trabajador trabajador = trabajadorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " +id));
        trabajadorRepository.delete(trabajador);
        return trabajadorMapper.toDto(trabajador);
}
}