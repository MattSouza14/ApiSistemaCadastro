package com.example.ApiSistemaCadastro;

public class NotificacaoEmailDTO {
    private String destinatario;
    private String assunto;
    private String mensagem;

    public NotificacaoEmailDTO(String destinatario, String assunto, String mensagem) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }


    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
