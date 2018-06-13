package ar.edu.grupoesfera.cursospring.twitter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.TwitRepository;
import ar.edu.grupoesfera.cursospring.twitter.service.SecurityService;
import ar.edu.grupoesfera.cursospring.twitter.service.TwitService;
import ar.edu.grupoesfera.cursospring.twitter.service.UsuarioService;
import groovyjarjarantlr.collections.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TwitRepositoryTest {
	
//	@Autowired
//	private TestEntityManager testEntityManager;
	
//	@Autowired
//	private SecurityService securityService;
	
	@Autowired
	private TwitService twitService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
//	@Test
//	public void getMyTimelineTest() {		
//		Usuario usuarioLogeado = testEntityManager.getEntityManager().find(Usuario.class, 1L);
//		
//		Usuario usuario1 = new Usuario();
//		usuario1.setNombre("Agustin");
//		usuario1.setEmail("amr@gmail.com");
//		
//		Usuario usuario2 = new Usuario();
//		usuario2.setNombre("Rodri");
//		usuario2.setEmail("rodri@gmail.com");
//		
//		testEntityManager.persist(usuario1);
//		testEntityManager.persist(usuario2);
//		
//		List<Usuario> misSeguidos = usuarioLogeado.getSeguidos();
//		misSeguidos.add(usuario1);
//		misSeguidos.add(usuario2);
//		
//		usuarioLogeado.setSeguidos(misSeguidos);
//
//		testEntityManager.persist(usuarioLogeado);
//
//		twit.setAutor(usuario1);
//		twit.setMensaje("HOLA QUE TAL");
//		testEntityManager.persist(twit);
//		
//		assertEquals(twitRepository.getTwitsByUsuario(securityService.getLogeado()).size(), 1);
//			
//		
//	}
	

	
}
