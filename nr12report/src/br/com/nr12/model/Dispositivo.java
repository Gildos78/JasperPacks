package br.com.nr12.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="dispositivo")
public class Dispositivo implements Serializable{

	private static final long serialVersionUID = 5996076149592332259L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	private String dispositivo;
	private String face;
	private String analiseProtecao;
	private String indicacaoSolucao;
	private String imagem;
	
	@ManyToOne
	@JoinColumn(name = "tipoDispositivoId")
	private TipoDispositivo tipoDispositivo;
	
	@OneToMany(mappedBy="pk.dispositivo")
	@OrderBy( value = "pk.pergunta" )
	private List<RespostaDispositivo> respostaDispositivo = new ArrayList<RespostaDispositivo>();
	
	@ManyToOne
	@JoinColumn(name = "laudoId")
	private Laudo laudo;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "normadispositivo", joinColumns = {
			@JoinColumn(name = "dispositivoId")},
			inverseJoinColumns = { @JoinColumn(name = "normaId")})
	private List<NormaRegulamentadora> normas;

	public List<NormaRegulamentadora> getNormas() {
		return normas;
	}

	public void setNormas(List<NormaRegulamentadora> normas) {
		this.normas = normas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getAnaliseProtecao() {
		return analiseProtecao;
	}

	public void setAnaliseProtecao(String analiseProtecao) {
		this.analiseProtecao = analiseProtecao;
	}

	public String getIndicacaoSolucao() {
		return indicacaoSolucao;
	}

	public void setIndicacaoSolucao(String indicacaoSolucao) {
		this.indicacaoSolucao = indicacaoSolucao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public List<RespostaDispositivo> getRespostaDispositivo() {
		return respostaDispositivo;
	}

	public void setRespostaDispositivo(List<RespostaDispositivo> respostaDispositivo) {
		this.respostaDispositivo = respostaDispositivo;
	}

	public Laudo getLaudo() {
		return laudo;
	}

	public void setLaudo(Laudo laudo) {
		this.laudo = laudo;
	}
	
}