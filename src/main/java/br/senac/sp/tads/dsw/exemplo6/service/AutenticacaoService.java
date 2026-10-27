package br.senac.sp.tads.dsw.exemplo6.service;

import java.rmi.registry.Registry;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import br.senac.sp.tads.dsw.exemplo6.dto.RegisterDTO;
import br.senac.sp.tads.dsw.exemplo6.model.Usuario;
import br.senac.sp.tads.dsw.exemplo6.repository.UsuarioRepository;


public class AutenticacaoService {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AutenticacaoService(UsuarioRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registrar(RegisterDTO dto) {
        if (repository.existsByLogin(null)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este login já está em uso!");
        }
        // Criptografa a senha com hash BCrypt antes de salvar no banco
        String senhaCriptografada = passwordEncoder.encode(dto.senha());
        Usuario novoUsuario = new Usuario(dto.login(), senhaCriptografada, dto.role());
        repository.save(novoUsuario);
    }

    
}
