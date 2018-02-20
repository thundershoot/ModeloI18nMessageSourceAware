package br.com.spring.bean;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class Aluno implements MessageSourceAware {

	private String nome;
	private Double nota;
	private MessageSource messageSource;

	public Aluno() {

	}

	public Aluno(String nome) {
		this.nome = nome;
	}

	@Override
	public void setMessageSource(MessageSource msgSource) {
		messageSource = msgSource;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		if (nota < 0 || nota > 10)
			throw new IllegalArgumentException(messageSource.getMessage("nota.invalida", null, null));

		this.nota = nota;
	}

}
