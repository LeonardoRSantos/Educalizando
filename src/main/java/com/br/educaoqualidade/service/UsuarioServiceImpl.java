package com.br.educaoqualidade.service;

import com.br.educaoqualidade.exceptions.ObjectNotFoundException;
import com.br.educaoqualidade.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{




    private UsuarioRepository userRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> result = userRepository.findById(id);
        return result.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id));
    }

    @Override
    public Usuario update(Usuario obj, Long id) {
        Usuario newUsuario = findById(id);

        newUsuario.setNome(obj.getNome());
        newUsuario.setEmail(obj.getEmail());
        newUsuario.setPassword(obj.getEmail());


        return userRepository.save(newUsuario);
    }

    @Override
    public List<Usuario> filterEmail(String email) {
        List<Usuario> obj = (List<Usuario>) userRepository.findByEmail(email);
        return obj;
    }

    public String delete(Long id) {

        try {
            userRepository.deleteById(id);

            String msg = "{msg: 'Excluido com sucesso'}";

            return msg;

        } catch (Exception e) {
            return e.toString();
        }
    }
}
