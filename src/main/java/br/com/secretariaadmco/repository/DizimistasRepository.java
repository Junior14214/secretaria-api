package br.com.secretariaadmco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.Dizimistas;

@Repository
public interface DizimistasRepository extends JpaRepository<Dizimistas, Integer> {

	@Query(value = "SELECT * FROM DIZIMISTAS WHERE TIPO=?1 AND CONGREGACAO=?2 AND DATA BETWEEN ?3 AND ?4", nativeQuery = true)
	public List<Dizimistas> relatorioMensal(Integer tipo, String congregacao, String data1, String data2);

	@Query(value = "SELECT COALESCE(SUM(VALOR),0) FROM DIZIMISTAS WHERE TIPO=?1 AND CONGREGACAO=?2 AND DATA BETWEEN ?3 AND ?4", nativeQuery = true)
	public Double somarValores(Integer tipo, String congregacao, String data1, String data2);

	@Query(value = "SELECT CONGREGACAO, SUM(VALOR) FROM DIZIMISTAS WHERE TIPO=?1 AND DATA BETWEEN ?2 AND ?3 GROUP BY CONGREGACAO", nativeQuery = true)
	public List<Object> relatorioGeralSede(Integer tipo, String data1, String data2);

	@Query(value = "SELECT TIPO, COUNT(TIPO) AS QUANTIDADE FROM DIZIMISTAS where congregacao=?1 GROUP BY TIPO", nativeQuery = true)
	public List<Object> relatorioDeEntradasCongregacoes(String congregacao);

	@Query(value = "SELECT TIPO, COUNT(TIPO) FROM DIZIMISTAS GROUP BY TIPO;", nativeQuery = true)
	public List<Object> relatorioDeEntradasCampo();

}
