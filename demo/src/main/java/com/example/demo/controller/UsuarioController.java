package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

        // endpoint para todos los Usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    // endpoint por id de Usuarios
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable Long id) {
        // Llamamos al servicio para obtener el usuario
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Usuario no encontrado");
            errorResponse.put("status", 404);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }


    // endpoint por crear un nuevo  Usuarios
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        // Llamamos al servicio para guardar el nuevo usuario
        Usuario newUsuario = usuarioService.saveUsuario(usuario);
        // Llamamos al respuesta del created el nuevo usuario
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
