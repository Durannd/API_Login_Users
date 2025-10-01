package br.edu.ifsp.ricael.api_login_users.controller;

import br.edu.ifsp.ricael.api_login_users.model.DTO.UsuarioDTO;
import br.edu.ifsp.ricael.api_login_users.model.DTO.UsuarioMapper;
import br.edu.ifsp.ricael.api_login_users.model.Usuario;
import br.edu.ifsp.ricael.api_login_users.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {

        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuarioMapper.map(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioMapper.map(savedUsuario));
    }

    @GetMapping
    public ResponseEntity<Iterable<UsuarioDTO>> getAllUsuarios() {
        Iterable<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(usuarioMapper.map(usuario));
        }
        return ResponseEntity.ok(usuarioDTOs);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody Usuario  usuario, @PathVariable Long id) {
        Optional<Usuario> updatedUsuario = usuarioService.update(id, usuario);
        if (updatedUsuario.isPresent()) {
            return ResponseEntity.ok(usuarioMapper.map(updatedUsuario.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
