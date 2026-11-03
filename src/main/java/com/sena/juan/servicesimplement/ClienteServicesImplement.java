package com.sena.juan.servicesimplement;

import java.util.List;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.stereotype.Service;

import com.sena.juan.dtos.ClienteDto;
import com.sena.juan.mappers.ClienteMapper;
import com.sena.juan.models.usuarios.Cliente;
import com.sena.juan.repositoryes.ClienteRepository;
import com.sena.juan.services.ClienteServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ClienteServicesImplement implements ClienteServices {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override 
    public ClienteDto guardar(ClienteDto clienteDto){
        Cliente cliente = clienteMapper.toCliente(clienteDto);

        Cliente clienteGuardado = clienteRepository.save(cliente);

        return clienteMapper.toDto(clienteGuardado);
    }

    //listar para cliente
    @Override 
    public List<ClienteDto> listarTodos(){
        return clienteRepository.findAll()
        .stream()
        .map(clienteMapper::toDto)
        .toList();
    }

    //consultar cliente por id
    @Override 
    public ClienteDto buscarPorId(Long id){
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " +id));
        return clienteMapper.toDto(cliente);

   
}
}
