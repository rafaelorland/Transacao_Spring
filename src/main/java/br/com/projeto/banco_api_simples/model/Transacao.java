package br.com.projeto.banco_api_simples.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUUID;

    private String remetente;

    private String destinatario;

    private int valor;

    private Date horarioDaTransacao;

    //GET and SET

    public String getRemetente() {
        return remetente;
    }
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public Date getHorarioDaTransacao() {
        return horarioDaTransacao;
    }
    public void setHorarioDaTransacao(Date horarioDaTransacao) {
        this.horarioDaTransacao = horarioDaTransacao;
    }
    
}
