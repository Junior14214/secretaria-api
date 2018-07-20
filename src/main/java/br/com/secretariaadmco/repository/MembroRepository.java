package br.com.secretariaadmco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.Membros;

@Repository
public interface MembroRepository extends JpaRepository<Membros, Integer> {

	@Query(value = "SELECT * FROM MEMBROS WHERE CONGREGACAO=?1 ORDER BY ID DESC", nativeQuery = true)
	public List<Membros> listarMembrosPorCongregacao(String congregacao);

	@Query(value = "SELECT COUNT(NOME) FROM MEMBROS WHERE CONGREGACAO=?1 AND SITUACAO=?2", nativeQuery = true)
	public Integer relatorioDeMebrosCongregacoes(String congregacao, String situacao);

	@Query(value = "SELECT COUNT(NOME) FROM MEMBROS WHERE SITUACAO=?1", nativeQuery = true)
	public Integer relatorioDeMebrosCampo(String situacao);

}
