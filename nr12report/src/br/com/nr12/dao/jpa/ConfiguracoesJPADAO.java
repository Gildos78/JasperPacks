package br.com.nr12.dao.jpa;

import java.util.List;
import javax.persistence.Query;
import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.Configuracoes;

public class ConfiguracoesJPADAO extends JPAConnection{
	
	public Configuracoes buscarConfiguracoes(){
		String jpql = "select conf from Configuracoes conf ";
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Configuracoes> list = query.getResultList();
		for (Configuracoes object: list){
			return ((Configuracoes) object);
		}
		return null;
	}
}
