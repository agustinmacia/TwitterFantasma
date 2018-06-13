package ar.edu.grupoesfera.cursospring.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;

public interface TwitRepository extends CrudRepository<Twit,Long>{

	@Query("SELECT t FROM Twit t where t.autor = ?1")
	public List<Twit> getTwitsByUsuario(Usuario usuario);
	

}
