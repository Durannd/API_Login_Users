package br.edu.ifsp.ricael.api_login_users.services;

import br.edu.ifsp.ricael.api_login_users.model.DTO.UsuarioMapper;
import br.edu.ifsp.ricael.api_login_users.model.Usuario;
import br.edu.ifsp.ricael.api_login_users.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public Optional<Usuario> findByEmail(String email) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByEmail(email));
        if(usuario.isPresent()){
            return usuario;
        }
        return  Optional.empty();
    }

    public Optional<Usuario> findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            return usuario;
        }
        return Optional.empty();
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> update(Long id, Usuario usuario) {
        Optional<Usuario> usuarioUpdate = usuarioRepository.findById(id);
        if (usuarioUpdate.isPresent()) {
            usuarioUpdate.get().setEmail(usuario.getEmail());
            usuarioUpdate.get().setName(usuario.getName());
            usuarioUpdate.get().setPassword(usuario.getPassword());
            usuarioUpdate.get().setCredits(usuario.getCredits());
            usuarioUpdate.get().setEteps(usuario.getEteps());
            usuarioRepository.save(usuarioUpdate.get());
            return usuarioUpdate;
        }
        return Optional.empty();
    }

}
