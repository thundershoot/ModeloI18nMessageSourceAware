package br.com.spring.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.spring.bean.Aluno;

public class Welcome implements MessageSourceAware {
	private static MessageSource messageSource;

	public static void main(String[] args) {
		ApplicationContext apContext = new ClassPathXmlApplicationContext(
				"/br/com/spring/config/ApplicationContext.xml");

		Locale.setDefault(Locale.US);
		String bemvindo_padrao_sistema = messageSource.getMessage("mensagem.bemvindo", null, null);
		System.out.println(bemvindo_padrao_sistema); // padrao do sistema.
		System.out.println(messageSource.getMessage("informar.nota", null, null));

		setNota(apContext);

	}

	public static void setNota(ApplicationContext applicationContext) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			Aluno aluno = (Aluno) applicationContext.getBean("beanAluno");
			aluno.setNota(Double.valueOf(s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setMessageSource(MessageSource arg0) {
		// TODO Auto-generated method stub
		messageSource = arg0;
	}

}
