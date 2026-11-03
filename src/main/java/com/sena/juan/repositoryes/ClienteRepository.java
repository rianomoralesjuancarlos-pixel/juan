package com.sena.juan.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.juan.models.usuarios.Cliente;

public interface ClienteRepository  extends JpaRepository <Cliente, Long>{

}
