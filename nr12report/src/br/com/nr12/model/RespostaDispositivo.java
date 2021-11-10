package br.com.nr12.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="respostadispositivo")
@AssociationOverrides({
	@AssociationOverride(name = "pk.dispositivo",
		joinColumns = @JoinColumn(name = "dispositivoId")),
	@AssociationOverride(name = "pk.pergunta",
		joinColumns = @JoinColumn(name = "perguntaId"))/*,
	@AssociationOverride(name = "resposta",
		joinColumns = @JoinColumn(name = "respostaId"))*/
	})
public class RespostaDispositivo implements Serializable{
	
	private static final long serialVersionUID = -1524684796595664914L;

	@ManyToOne
	@JoinColumn(name = "respostaId")
	private Resposta resposta;
		
	@EmbeddedId
	private RespostaDispositivoId pk = new RespostaDispositivoId();
	
//	@MapsId("dispositivo")
//	@ManyToOne
//	private Dispositivo dispositivo;
	
	public RespostaDispositivoId getPk() {
		return pk;
	}
	public void setPk(RespostaDispositivoId pk) {
		this.pk = pk;
	}
	
	@Transient
	//@ElementCollection(targetClass=Dispositivo.class)
	public Dispositivo getDispositivo(){
		return getPk().getDispositivo();
	}
	public void setDispositivo(Dispositivo dispositivo){
		getPk().setDispositivo(dispositivo);
	}
	
	@Transient
	//@ElementCollection(targetClass=Pergunta.class)
	public Pergunta getPergunta(){
		return getPk().getPergunta();
	}
	public void setPergunta(Pergunta pergunta){
		getPk().setPergunta(pergunta);
	}
	
	public Resposta getResposta() {
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	@Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RespostaDispositivo that = (RespostaDispositivo) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}
	
	/*
	@ManyToOne
	@JoinColumn(name="dispositivoId")
	private Dispositivo dispositivo;
	
	@ManyToOne
	@JoinColumn(name="perguntaId")
	private Pergunta pergunta;
	*/
}