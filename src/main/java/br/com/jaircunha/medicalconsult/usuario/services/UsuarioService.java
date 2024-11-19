package br.com.jaircunha.medicalconsult.usuario.services;

import br.com.jaircunha.medicalconsult.usuario.domain.Usuario;
import br.com.jaircunha.medicalconsult.usuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
