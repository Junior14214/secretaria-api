package br.com.secretariaadmco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.Usuario;
import br.com.secretariaadmco.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario buscarInformacoesUsuarioLogado(String uid) {
		return usuarioRepository.buscarInformacoesUsuarioLogado(uid);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

}
