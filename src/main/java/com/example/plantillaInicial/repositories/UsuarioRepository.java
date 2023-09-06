package com.example.plantillaInicial.repositories;

import com.example.plantillaInicial.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {

    public abstract ArrayList<UsuarioModel> findAllByEmail(String email);

}
