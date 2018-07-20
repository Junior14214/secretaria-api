package br.com.secretariaadmco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariaadmco.model.Usuario;
import br.com.secretariaadmco.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioService.salvar(usuario);

		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Usuario> buscarInformacoesUsuarioLogado(@PathVariable String uid) {
		Usuario usuarioLogado = usuarioService.buscarInformacoesUsuarioLogado(uid);

		return new ResponseEntity<>(usuarioLogado, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> lista = usuarioService.listarUsuarios();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
