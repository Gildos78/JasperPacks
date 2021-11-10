package br.com.nr12.dao.jpa;

import java.util.List;
import javax.persistence.Query;
import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.Cliente;

public class ClienteJPADAO extends JPAConnection{
	
	public Cliente buscarCliente(int idLaudo){
		String jpql = "select  c from Cliente c "
			        + " where  c.id = (select m.cliente from Maquina m where m.id = (select l.maquina from Laudo l where l.id = "+idLaudo+"))";
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Cliente> list = query.getResultList();
		for (Cliente object: list){
			return ((Cliente) object);
		}
		return null;
	}
}
