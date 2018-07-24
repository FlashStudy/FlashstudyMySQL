package br.com.flashstudy.error;

//Retornar uma mensagem de erro ou sucesso
public class Resposta {
	private String mensagem;

	public Resposta() {
		super();
	}

	public Resposta(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
