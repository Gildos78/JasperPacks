package br.com.nr12.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipomaquina")
public class TipoMaquina{
	
	@Id
	private int id;
	private String nome;
	private String descricao;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="capacitacaoId")
	private Capacitacao capacitacao;
	//private Introducao introducao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Capacitacao getCapacitacao() {
		return capacitacao;
	}
	public void setCapacitacao(Capacitacao capacitacao) {
		this.capacitacao = capacitacao;
	}
	/*
	public Introducao getIntroducao() {
		return introducao;
	}
	public void setIntroducao(Introducao introducao) {
		this.introducao = introducao;
	}
	*/
}