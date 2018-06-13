package ar.edu.grupoesfera.cursospring.twitter.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u")
	public List<Usuario> getUsuarios();
	
	List<Usuario> findByEmail(String email);
	
	@Query("select u from Usuario u where ?1 in elements(u.seguidos)")
	List<Usuario> obtenerSeguidores(Usuario usuario);

	@Query("Select u.seguidos FROM Usuario u where u = ?1")
	public List<Usuario> getSeguidos(Usuario usuario);

}
