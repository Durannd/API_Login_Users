package br.edu.ifsp.ricael.api_login_users.model.DTO;

import br.edu.ifsp.ricael.api_login_users.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO map(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getName(), usuario.getEmail(), usuario.getPassword(), usuario.getCredits(), usuario.getEteps());
    }
    public Usuario map(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.id(), usuarioDTO.name(), usuarioDTO.email(),  usuarioDTO.password(), usuarioDTO.credits(), usuarioDTO.eteps());
    }
}
