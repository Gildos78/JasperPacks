package br.com.nr12.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.DisposicaoFinal;

public class DisposicaoFinalJPADAO extends JPAConnection{
	public List<DisposicaoFinal> buscarDisposicaoFinalLaudo(int idLaudo){
		String jpql = "select n  from  Laudo l join l.disposicaoFinal n "
			        + "where l.id = "+idLaudo;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<DisposicaoFinal> list = query.getResultList();
		return list;
	}
}
