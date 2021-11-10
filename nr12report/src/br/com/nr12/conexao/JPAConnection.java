package br.com.nr12.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAConnection {
	private EntityManagerFactory conexao;
	private static EntityManager em = null;
	
	private EntityManagerFactory conectar() {
		try{
			if (conexao != null && conexao.isOpen()){
				return conexao;
			}
		}catch(Exception e){
			
		}
		conexao = Persistence.createEntityManagerFactory("NR12");// nome da tag <persistence-unit
		return conexao;
		//EntityManager em = conexao.createEntityManager();
	}
	
	//esse metodo sera o nosso createdStatement
	protected EntityManager getEntityManager(){
		em = conectar().createEntityManager();
		return em;
	}
	
	//este metodo sera o nosso prepareStatement
	protected Query getQuery(String jpql){
		return this.getEntityManager().createQuery(jpql);
	}
}
