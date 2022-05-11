package com.br.educaoqualidade.service;

import com.br.educaoqualidade.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario create(Usuario usuario);
    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario update(Usuario obj, Long id);
    public List<Usuario> filterEmail(String email);
}
