package br.senac.sp.tads.dsw.exemplo6.repository;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.senac.sp.tads.dsw.exemplo6.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByLogin(String login);
    Optional<UserDetails> findbyLogin(String login);
    
}
