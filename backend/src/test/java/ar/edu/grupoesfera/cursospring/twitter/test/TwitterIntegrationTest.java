package ar.edu.grupoesfera.cursospring.twitter.test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;
import ar.edu.grupoesfera.cursospring.twitter.service.TwitService;
import ar.edu.grupoesfera.cursospring.twitter.service.UsuarioService;

import static org.hamcrest.core.Is.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TwitterIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TwitService twitService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@org.junit.Before
	public void inicializar() {
		// delete all en el repository
	}
	
		
	@Test
	public void isAliveTrue() {
		expect()
				.statusCode(is(HttpStatus.OK.value()))
		.when()
				.get(String.format("http://localhost:%s/api/rest/isAlive", port)).peek();
	}
	
    @Test
    public void testTimeline() {
//      String url = String.format("http://localhost/%s/api/rest/", port);

        Usuario mati = new Usuario("Reimond");
        Usuario mica = new Usuario("Mica");


        Twit tweet = new Twit(mati, "Uhh re bien.", LocalDateTime.now());

        usuarioService.insertUsuario(mati);
        usuarioService.insertUsuario(mica);

        mica.getSeguidos().add(mati);

        usuarioService.insertUsuario(mica);

        twitService.twittear(tweet, mati);

        assertTrue(!twitService.getTwitsByUsuario(mati.getId()).isEmpty());
    }
}
