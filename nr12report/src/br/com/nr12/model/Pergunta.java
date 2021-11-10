package br.com.nr12.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pergunta")
public class Pergunta {
	
	@Id
	private int id;
	private String pergunta;

	@ManyToOne
	@JoinColumn(name = "tipoDispositivoId")
	private TipoDispositivo tipoDispositivo;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "perguntaresposta", joinColumns = {
			@JoinColumn(name = "perguntaId")},
			inverseJoinColumns = { @JoinColumn(name = "respostaId")})
	private List<Resposta> respostas;
	
	@ManyToOne
	@JoinColumn(name = "respostaCorreta")
	private Resposta respostaCorreta;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "respostaDispositivo", joinColumns = {
			@JoinColumn(name = "respostaId")})
			//inverseJoinColumns = { @JoinColumn(name = "respostaId")})
	private Resposta resposta;
	*/
	
	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}
	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	public Resposta getRespostaCorreta() {
		return respostaCorreta;
	}
	public void setRespostaCorreta(Resposta respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}
	
}