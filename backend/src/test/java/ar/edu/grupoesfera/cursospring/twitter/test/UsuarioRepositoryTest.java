package ar.edu.grupoesfera.cursospring.twitter.test;


import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@Transactional
@DataJpaTest
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private Usuario amr;
	private Usuario hfm;
	
	@Test
	public void crearUsuario() {
		
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setNombre("Agus");
		usuarioNuevo.setEmail("amr@gmail.com");
		
		this.usuarioRepository.save(usuarioNuevo);
		
		assertThat(usuarioNuevo).extracting("id").isNotNull();
	}

}
