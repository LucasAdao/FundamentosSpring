package br.com.lucasadao.projeto_rocketseat.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {
	
	@GetMapping("/primeiroMetodo")
	public String primeiroMetodo( ) {
		return "Parabésssns! Você criou sua Primeira Rotaaa!";
	}
	
	@GetMapping("/PathParams/{id}")
	public String pathParams(@PathVariable String id) {
		return "Seu nome é " + id;
	}
	//?id=12
	@GetMapping("/metodoComQueryParams")
	public String metodoComQueryParams(@RequestParam String id) {
	    return "O parâmetro metodoComQueryParams é " + id;
	}
	
	//?id=12&curso=Java&nome=lucas
	@GetMapping("/metodoComQueryParamsDois")
	public String metodoComQueryParamsDois(@RequestParam Map<String, String> allParams) {
	    return "O parâmetro metodoComQueryParams é " + allParams.entrySet();
	}
	
	//no postoman { "nome" }
	@PostMapping("/metodoComBodyParams")
	public String metodoComBodyParams(@RequestBody Usuario usuario) {
		return "Nomes" + usuario.username();
	}
	//Colocar key e value no postman
	@PostMapping("/metodoComHeadersParams")
	public String metodoComHeadersParams(@RequestHeader("name") String name) {
		return "Nomes " + name;
	}
	
	//colocar varias keys e varios values no postman
	@PostMapping("/metodoComHeadersParamsList")
	public String metodoComHeadersParamsList(@RequestHeader Map<String,String> headers) {
		return "Nomes " + headers.entrySet();
	}
	
	//só pegar o get e gg
	@GetMapping("/metodoResponseEntity")
	public ResponseEntity<Object> metodoResponseEntity(){
		return ResponseEntity.status(HttpStatus.CREATED).body("Mensagem de erro");
	}
	
	
	//se id for menor que 5 vai dar um bad request
	@GetMapping("/brincandoComReponse/{id}")
	public ResponseEntity<Object> brincandoComReponse(@PathVariable Long id){
		var usuario = new Usuario("Lucas");
		if(id > 5) {
			return ResponseEntity.status(HttpStatus.OK).body(usuario);
		}
		return ResponseEntity.badRequest().body("Numero menor que 5"); 
	}
	record Usuario(String username) {
	}
}
