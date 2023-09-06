package com.example.plantillaInicial.services;

import com.example.plantillaInicial.models.UsuarioModel;
import com.example.plantillaInicial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> getUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel createUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    // como el metodo puede fallar al no encontrar el id se pone optional
    public Optional<UsuarioModel> getById(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> getByEmail(String email){
        return usuarioRepository.findAllByEmail(email);
    }

    public boolean deleteUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }


}
