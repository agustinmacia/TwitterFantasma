package ar.edu.grupoesfera.cursospring.twitter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Favorito;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;

public interface FavRepository extends CrudRepository<Favorito,Long> {

	@Query("SELECT f from Favorito f where f.twit = ?1 AND f.usuario = ?2")
	public Favorito existeFav(Twit twit, Usuario user); 
}
