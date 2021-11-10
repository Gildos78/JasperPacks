package br.com.nr12.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import br.com.nr12.conexao.JPAConnection;
import br.com.nr12.model.Dispositivo;
import br.com.nr12.model.Intervencao;
import br.com.nr12.model.Laudo;
import br.com.nr12.model.PontoPerigo;

public class LaudoJPADAO extends JPAConnection{
	
	public Laudo buscarPrimeiraPagina(int id){
		String jpql = "select laudo from Laudo laudo "
				    + "inner join laudo.maquina "
				    + "where laudo.id = "+ id;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Laudo> list = query.getResultList();
		for (Laudo object: list){
			return ((Laudo) object);
		}
		return null;
	}
	
	public List<Dispositivo> buscarDispositivos(int idLaudo){
		String jpql = "select d  from  Laudo l join l.dispositivos d "
			        + "where l.id = "+idLaudo;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Dispositivo> list = query.getResultList();
		return list;
	}
	
	public List<Intervencao> buscarIntervencao(int idLaudo){
		String jpql = "select d  from  Laudo l join l.intervencao d "
			        + "where l.id = "+idLaudo;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Intervencao> list = query.getResultList();
		return list;
	}
	
	public List<PontoPerigo> buscarPontosPerigo(int idLaudo){
		String jpql = "select d  from  Laudo l join l.pontosPerigo d "
			        + "where l.id = "+idLaudo;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<PontoPerigo> list = query.getResultList();
		return list;
	}
	
	/*public Laudo buscarPorId(int id){
		String jpql = "select laudo from Laudo laudo "
				    + "inner join laudo.usuario "
				    + "inner join laudo.maquina "
				    + "where laudo.id = "+ id;
		Query query = super.getQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Laudo> list = query.getResultList();
		for (Laudo object: list){
			return ((Laudo) object);
		}
		return null;
	}*/
}
