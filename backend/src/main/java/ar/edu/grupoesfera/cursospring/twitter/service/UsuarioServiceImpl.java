package ar.edu.grupoesfera.cursospring.twitter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private SecurityService securityService;
	
	public UsuarioRepository getRepository() {
		return repository;
	}

	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return repository.getUsuarios();
	}
	
	@Override
	public Optional<Usuario> getUsuarioById(Long id){
		return Optional.ofNullable(repository.findOne(id));
		
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		repository.save(usuario);		
	}

	@Override
	public List<Usuario> getSeguidos() {
		Usuario user = securityService.getLogeado();
		
		return repository.getSeguidos(user);
	}

	@Override
	public void seguir(Usuario usuario) {
		Usuario user = securityService.getLogeado();
		user.agregarSeguido(usuario);
		
		repository.save(user);
		
	}

	@Override
	public List<Usuario> getSeguidores(Long id) {
		Usuario user = repository.findOne(id);
		
		return repository.obtenerSeguidores(user);
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		repository.delete(usuario.getId());
		
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		repository.save(usuario);
		
	}
	
}
