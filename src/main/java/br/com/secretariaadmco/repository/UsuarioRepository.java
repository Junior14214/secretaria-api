package br.com.secretariaadmco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	@Query(value="SELECT * FROM USUARIO WHERE UID=?1", nativeQuery=true)
	public Usuario buscarInformacoesUsuarioLogado(String uid);

}
