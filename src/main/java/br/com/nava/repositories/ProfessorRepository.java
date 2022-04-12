package br.com.nava.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.nava.entities.ProfessorEntity;



//@Repository avisa que é uma camada de depedencia do banco e avisa que tbm terá uma injeção de dependencia
//JpaRepository fica responsável por pegar os dados do Java e iserir no banco
@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {

}
