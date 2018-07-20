package br.com.secretariaadmco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.Financeiro;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Integer> {

//	@Query(value = "INSERT INTO FINANCEIRO (ID, CONGREGACAO, ENTRADAS, PERIODO, SAIDAS, TOTAL) VALUES (? ,?, ?, ?, ?, ?)", nativeQuery = true)
//	public void salvar(int id, String congregacao, double entradas, String periodo, double saidas, double total);
	
	@Query(value = "select * from financeiro order by id desc limit 1", nativeQuery = true)
	public Integer sdfsd();

}
