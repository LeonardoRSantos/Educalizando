package repository;

import com.br.educaoqualidade.model.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {

}
