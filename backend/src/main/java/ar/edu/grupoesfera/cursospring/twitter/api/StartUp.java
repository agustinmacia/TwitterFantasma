package ar.edu.grupoesfera.cursospring.twitter.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;

@Component
public class StartUp implements ApplicationRunner{
	
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(ApplicationArguments argumentos) throws Exception{
		Usuario usuario = new Usuario();
		usuario.setNombre("AMR");
		usuario.setEmail("amaciadelrio@gmail.com");
		
		this.usuarioRepository.save(usuario);
		
		Twit twit = new Twit();
		twit.setAutor(usuario);
		twit.setMensaje("HOLA HOLA HOLA");
		twit.setFechaCreacion(LocalDateTime.now());
		
	}
	
	@Autowired
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
}
