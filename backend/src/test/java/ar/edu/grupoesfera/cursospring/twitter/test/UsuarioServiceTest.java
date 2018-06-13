package ar.edu.grupoesfera.cursospring.twitter.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;
import ar.edu.grupoesfera.cursospring.twitter.service.UsuarioService;
import ar.edu.grupoesfera.cursospring.twitter.service.UsuarioServiceImpl;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {
	
	@MockBean
	UsuarioRepository usuarioRepository;
	
	Usuario user1 = new Usuario();
	Usuario user2 = new Usuario();
	
	
	@Before
	public void init() {
		
		user1.setNombre("jokelum");
		user1.setEmail("El-Jokelum-activa2@gmail.com");
		
		user2.setNombre("laut1");
		user2.setEmail("laut1@gmail.com");
		
		
	}
	
	
	@Test
	public void getUsuariosTest() {	
			
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(user1);
		usuarios.add(user2);
		
		when(usuarioRepository.getUsuarios()).thenReturn(usuarios);
		
		UsuarioService usuarioService = new UsuarioServiceImpl();
		usuarioService.setRepository(usuarioRepository);
		
		assertEquals(usuarioService.getUsuarios(), usuarios);
		
	}
	
//	@Test
//	public void getUsuarioById() {
//		Usuario user1 = new Usuario();
//		user1.setNombre("fabian");
//		user1.setId((long) 1);		
//		
//		when(usuarioRepository.getUsuarioById((long) 1)).thenReturn(Optional.ofNullable(user1));
//		
//		UsuarioService usuarioService = new UsuarioServiceImpl();
//		usuarioService.setRepository(usuarioRepository);
//		
//		assertEquals(usuarioService.getUsuarioById(Long.valueOf(1)).get(), user1);
//	}
	
//	@Test
//	public void getUsuariosByIdSALEMAL() {
//
//		when(usuarioRepository.getUsuarioById((long) 1)).thenReturn(Optional.ofNullable(null));
//		
//		UsuarioService usuarioService = new UsuarioServiceImpl();
//		usuarioService.setRepository(usuarioRepository);
//		
//		assertFalse(usuarioService.getUsuarioById(Long.valueOf(1)).isPresent());
//	}
	
	

}
