package br.com.nr12.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.NormaTecnica;

public class NormaTecnicaJPADAO extends JPAConnection{
	
	public List<NormaTecnica> buscarNormaTecnicaLaudo(int idLaudo){
		String jpql = "select n  from  Laudo l join l.normasTecnicas n "
			        + "where l.id = "+idLaudo;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<NormaTecnica> list = query.getResultList();
		return list;
	}
}
