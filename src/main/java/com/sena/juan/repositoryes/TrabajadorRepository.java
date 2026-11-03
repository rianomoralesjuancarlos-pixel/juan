package com.sena.juan.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.juan.models.usuarios.Trabajador;

public interface TrabajadorRepository extends JpaRepository <Trabajador, Long>{

}
