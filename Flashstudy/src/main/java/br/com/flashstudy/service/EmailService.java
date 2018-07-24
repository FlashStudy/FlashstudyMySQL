package br.com.flashstudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.flashstudy.model.Duvida;
import br.com.flashstudy.model.Usuario;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void enviarEmailCadastro(Usuario usuario) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(usuario.getEmail());
		mail.setFrom("flashstudy4@gmail.com");
		mail.setSubject("Bem-vindo!");
		mail.setText("Olá " + usuario.getNome() + ", agradecemos pelo seu registro na nossa plataforma! Esperamos que tenha uma excelente experiência!");
	
		javaMailSender.send(mail);
	}
	
	public void enviarEmailDuvida(Usuario usuario, Duvida duvida) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("flashstudy4@gmail.com");
		mail.setFrom("flashstudy4@gmail.com");
		mail.setSubject(duvida.getAssunto());
		mail.setText(duvida.getMensagem() + "\n Email: " + usuario.getEmail() + "\n Nome:" + usuario.getNome());
	
		javaMailSender.send(mail);
	}
	
	public void enviarEmailAtualizacao(Usuario usuario) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(usuario.getEmail());
		mail.setFrom("flashstudy4@gmail.com");
		mail.setSubject("Atualização de dados");
		mail.setText("Seus dados foram atualizados com sucesso!");
	
		javaMailSender.send(mail);
	}
}
