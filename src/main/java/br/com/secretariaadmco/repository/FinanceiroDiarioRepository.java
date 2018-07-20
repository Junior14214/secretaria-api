package br.com.secretariaadmco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariaadmco.model.FinanceiroDiario;

@Repository
public interface FinanceiroDiarioRepository extends JpaRepository<FinanceiroDiario, Integer> {
	
	@Query(value="SELECT * FROM FINANCEIRO_DIARIO WHERE CONGREGACAO=?1", nativeQuery=true)
	public FinanceiroDiario pesquisarCongregacao(String congregacao);

}
