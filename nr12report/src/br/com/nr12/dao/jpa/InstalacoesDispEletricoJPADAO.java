package br.com.nr12.dao.jpa;

import java.util.List;
import javax.persistence.Query;
import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.Configuracoes;
import br.com.nr12.model.InstalacoesDispEletrico;
import br.com.nr12.model.NormaTecnica;

public class InstalacoesDispEletricoJPADAO extends JPAConnection{
	
	
	public List<InstalacoesDispEletrico> buscarInstalacoesDispEletricoLaudo(int idLaudo){
		String jpql = "select n  from  Laudo l join l.instalacoesDispEletrico n "
			        + "where l.id = "+idLaudo;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<InstalacoesDispEletrico> list = query.getResultList();
		return list;
	}
}
