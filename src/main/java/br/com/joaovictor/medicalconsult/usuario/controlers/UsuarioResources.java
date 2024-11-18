package br.com.joaovictor.medicalconsult.usuario.controlers;

import br.com.joaovictor.medicalconsult.usuario.domain.Usuario;
import br.com.joaovictor.medicalconsult.usuario.services.UsuarioService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResources {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> atualizarCliente(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario upCliente = usuarioService.atualizarUsuario(id,usuario);
        return ResponseEntity.ok().body(upCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.ok("Usuario excluido com sucesso!");
    }
}

