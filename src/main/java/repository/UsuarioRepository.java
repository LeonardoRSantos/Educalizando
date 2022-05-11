package repository;

import com.br.educaoqualidade.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

//    @Query("select u from Usuario u where u.email like %?1%")
//    List<Usuario> findUsuarioByEmail(String email);
}
