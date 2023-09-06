package com.example.plantillaInicial.controllers;

import com.example.plantillaInicial.models.UsuarioModel;
import com.example.plantillaInicial.services.UsuarioService;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public UsuarioModel createUsuario(@RequestBody UsuarioModel usuario){
        return  usuarioService.createUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getById(@PathVariable("id") Long id){
        return  this.usuarioService.getById(id);
    }

    @GetMapping("/consulta/{email}")
    public ArrayList<UsuarioModel> getByEmail(@PathVariable("email") String email){
        return this.usuarioService.getByEmail(email);
    }

    @DeleteMapping(path = "/{id}")
    public  String deleteUsuario(@PathVariable("id") Long id){

        boolean confirmacion = this.usuarioService.deleteUsuario(id);

        if (confirmacion){
            return "Se elinino el usuario con id " + id;
        }else{
            return "No se puedo eliminar el usuario con el id " +id;
        }

    }

}
