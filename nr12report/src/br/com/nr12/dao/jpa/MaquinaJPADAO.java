package br.com.nr12.dao.jpa;

import java.util.List;
import javax.persistence.Query;
import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.Maquina;

public class MaquinaJPADAO extends JPAConnection{
	
	public Maquina buscarMaquina(int idLaudo){
		String jpql = "select m from Maquina m "
			        + "where m.id = (select l.maquina from Laudo l where l.id = "+idLaudo+")";
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Maquina> list = query.getResultList();
		for (Maquina object: list){
			return ((Maquina) object);
		}
		return null;
	}
}
