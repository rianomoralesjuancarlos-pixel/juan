package com.sena.juan.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.juan.models.usuarios.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

}
