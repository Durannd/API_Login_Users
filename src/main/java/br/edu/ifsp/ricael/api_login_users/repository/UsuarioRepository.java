package br.edu.ifsp.ricael.api_login_users.repository;

import br.edu.ifsp.ricael.api_login_users.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByName(String name);
}
