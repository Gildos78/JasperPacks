package br.com.nr12.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.Manual;

public class ManualJPADAO extends JPAConnection{
	
	
	public List<Manual> buscarManualLaudo(int idLaudo){
		String jpql = "select n  from  Laudo l join l.manual n "
			        + "where l.id = "+idLaudo;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Manual> list = query.getResultList();
		return list;
	}
}
