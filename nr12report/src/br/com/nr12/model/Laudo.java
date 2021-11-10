package br.com.nr12.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="laudo")
public class Laudo{
	
	@Id
	private int id;
	
	private String codigo;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="usuarioId")
	private Usuario usuario;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="responsavelId")
	private Usuario responsavel;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="maquinaId")
	private Maquina maquina;
	
	private String status;
	
	@Column(name="data_inicial")
	private Date dataInicial;
	
	@Column(name="data_final")
	private Date dataFinal;
	
	private String limitesMaquina;
	private String imagem;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "normatecnicalaudo", joinColumns = {
			@JoinColumn(name = "laudoId")},
			inverseJoinColumns = { @JoinColumn(name = "normaTecnicaId")})
	private List<NormaTecnica> normasTecnicas;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "instalacoesdispeletricolaudo", joinColumns = {
			@JoinColumn(name = "laudoId")},
			inverseJoinColumns = { @JoinColumn(name = "instalacoesdispeletricoId")})
	private List<InstalacoesDispEletrico> instalacoesDispEletrico;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "manuallaudo", joinColumns = {
			@JoinColumn(name = "laudoId")},
			inverseJoinColumns = { @JoinColumn(name = "manualId")})
	private List<Manual> manual;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "disposicaofinallaudo", joinColumns = {
			@JoinColumn(name = "laudoId")},
			inverseJoinColumns = { @JoinColumn(name = "disposicoesfinaisId")})
	private List<DisposicaoFinal> disposicaoFinal;
	
	@OneToMany(mappedBy = "laudo")
	private List<Dispositivo> dispositivos;
	
	@OneToMany(mappedBy = "laudo")
	private List<PontoPerigo> pontosPerigo;
	
	@OneToMany(mappedBy = "laudo")
	private List<Intervencao> intervencao;
	
	public List<Intervencao> getIntervencao() {
		return intervencao;
	}

	public void setIntervencao(List<Intervencao> intervencao) {
		this.intervencao = intervencao;
	}
	
	public List<PontoPerigo> getPontosPerigo() {
		return pontosPerigo;
	}

	public void setPontosPerigo(List<PontoPerigo> pontosPerigo) {
		this.pontosPerigo = pontosPerigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getLimitesMaquina() {
		return limitesMaquina;
	}

	public void setLimitesMaquina(String limitesMaquina) {
		this.limitesMaquina = limitesMaquina;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<NormaTecnica> getNormasTecnicas() {
		return normasTecnicas;
	}

	public void setInstalacoesDispEletrico(List<InstalacoesDispEletrico> instalacoesDispEletrico) {
		this.instalacoesDispEletrico = instalacoesDispEletrico;
	}
	
	public List<InstalacoesDispEletrico> getInstalacoesDispEletrico() {
		return instalacoesDispEletrico;
	}

	public void setNormasTecnicas(List<NormaTecnica> normasTecnicas) {
		this.normasTecnicas = normasTecnicas;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
	
	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	public void setManual(List<Manual> manual) {
		this.manual = manual;
	}
	
	public List<Manual> getManual() {
		return manual;
	}
	public void setDisposicaoFinal(List<DisposicaoFinal> disposicaoFinal) {
		this.disposicaoFinal = disposicaoFinal;
	}
	
	public List<DisposicaoFinal> getDisposicaoFinal() {
		return disposicaoFinal;
	}
}