package com.br.educaoqualidade.controller;

import com.br.educaoqualidade.model.Usuario;
import com.br.educaoqualidade.service.UsuarioService;
import com.br.educaoqualidade.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/create")
    private ResponseEntity<String> salvar(@RequestBody @Valid Usuario usuario) {
        usuarioService.create(usuario);
        return ResponseEntity.ok("Novo Usuario Cadastrado");

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        String msg = ((UsuarioServiceImpl) usuarioService).delete(id);

        return ResponseEntity.ok().body(msg);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Usuario update(@RequestBody @Valid Usuario usuario, @PathVariable Long id) {
        return usuarioService.update(usuario, id);
    }

    @RequestMapping(value = "/*/*", method = RequestMethod.POST)
    public ResponseEntity<List<Usuario>> filterEmail(@RequestParam(value = "email")String email){
        List<Usuario> obj = usuarioService.filterEmail(email);

        return ResponseEntity.ok().body(obj);
    }
}
