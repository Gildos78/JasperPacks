package br.com.nr12.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RespostaDispositivoId implements Serializable{
	
	private static final long serialVersionUID = 3837892562325286668L;
	
	@ManyToOne
	@JoinColumn(name = "dispositivoId", nullable = false)
	private Dispositivo dispositivo;
	
	@ManyToOne
	@JoinColumn(name = "perguntaId", nullable = false)
	private Pergunta pergunta;
	
	
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespostaDispositivoId that = (RespostaDispositivoId) o;

        if (dispositivo != null ? !dispositivo.equals(that.dispositivo) : that.dispositivo != null) return false;
        if (pergunta != null ? !pergunta.equals(that.pergunta) : that.pergunta != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (dispositivo != null ? dispositivo.hashCode() : 0);
        result = 31 * result + (pergunta != null ? pergunta.hashCode() : 0);
        return result;
    }
}