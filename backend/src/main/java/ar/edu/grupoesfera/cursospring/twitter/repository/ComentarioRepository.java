package ar.edu.grupoesfera.cursospring.twitter.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Comentario;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Favorito;

public interface ComentarioRepository extends CrudRepository<Comentario,Long>{

}
