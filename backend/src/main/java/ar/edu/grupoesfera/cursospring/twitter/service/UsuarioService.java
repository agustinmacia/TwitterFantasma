package ar.edu.grupoesfera.cursospring.twitter.service;

import java.util.List;
import java.util.Optional;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;

public interface UsuarioService {

	public List<Usuario> getUsuarios();
	public Optional<Usuario> getUsuarioById(Long id);
	public UsuarioRepository getRepository();
	public void setRepository(UsuarioRepository repository);
	public void insertUsuario(Usuario usuario);
	public List<Usuario> getSeguidos();
	public void seguir(Usuario usuario);
	public List<Usuario> getSeguidores(Long id);
	public void borrarUsuario(Usuario usuario);
	public void modificarUsuario(Usuario usuario);
	

}
