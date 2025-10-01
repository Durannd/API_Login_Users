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
@RequestMapping("/usuarios") // Caminho base para todos os endpoints
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    // Ação: Obter um usuário por ID
    // Método: GET
    // URL: /usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuarioMapper.map(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    // Ação: Criar um novo usuário
    // Método: POST
    // URL: /usuarios
    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioMapper.map(savedUsuario));
    }

    // Ação: Obter todos os usuários
    // Método: GET
    // URL: /usuarios
    @GetMapping
    public ResponseEntity<Iterable<UsuarioDTO>> getAllUsuarios() {
        Iterable<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(usuarioMapper.map(usuario));
        }
        return ResponseEntity.ok(usuarioDTOs);
    }

    // Ação: Atualizar um usuário
    // Método: PATCH
    // URL: /usuarios/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody Usuario  usuario, @PathVariable Long id) {
        // PROVA DE VIDA: VAMOS VER SE ESTA MENSAGEM APARECE NOS LOGS
        System.out.println("--- CONTROLLER: DENTRO DO MÉTODO updateUsuario ---");
        Optional<Usuario> updatedUsuario = usuarioService.update(id, usuario);
        if (updatedUsuario.isPresent()) {
            return ResponseEntity.ok(usuarioMapper.map(updatedUsuario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    // Ação: Apagar um usuário
    // Método: DELETE
    // URL: /usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        // PROVA DE VIDA: VAMOS VER SE ESTA MENSAGEM APARECE NOS LOGS
        System.out.println("--- CONTROLLER: DENTRO DO MÉTODO deleteUsuario ---");
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

