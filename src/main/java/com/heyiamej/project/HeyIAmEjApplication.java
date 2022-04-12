package com.heyiamej.project;

import com.heyiamej.project.dto.request.AtividadeDTO;
import com.heyiamej.project.dto.request.ProfissaoDTO;
import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Profissao;
import com.heyiamej.project.service.AtividadeService;
import com.heyiamej.project.service.ProfissaoService;
import com.heyiamej.project.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HeyIAmEjApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeyIAmEjApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(ProfissaoService profissaoService,
						  AtividadeService atividadeService,
						  UsuarioService usuarioService) {
		return args -> {
			//Criando Profissões
			MessageResponseDTO teste = profissaoService.createProfissao(new ProfissaoDTO(1L, "Ciência da Computação", "CCO", null));
			teste = profissaoService.createProfissao(new ProfissaoDTO(2L, "Recursos Humanos", "RH", null));
			teste = profissaoService.createProfissao(new ProfissaoDTO(3L, "Técnico em Manutenção", "TM", null));

			//Criando Atividades
			teste = atividadeService.createAtividade(new AtividadeDTO(1L, "Desenvolver API Basica", "Conceitos básicos de API", 3, 1));
			teste = atividadeService.createAtividade(new AtividadeDTO(2L, "Mentoria Junior", "Mentoria aos Juniores", 2, 1));
			teste = atividadeService.createAtividade(new AtividadeDTO(3L, "Reuniões de Planejamento", "Reuniões de planejamento e contratos com Cliente", 1, 1));
			teste = atividadeService.createAtividade(new AtividadeDTO(4L, "Efetivação de Usuarios", "Efetivação de contratos de usuarios", 1, 2));
			teste = atividadeService.createAtividade(new AtividadeDTO(5L, "Processos Seletivos", "Planejamento de processos seletivos", 3, 2));
			teste = atividadeService.createAtividade(new AtividadeDTO(6L, "Arquitetura de Softwares", "Desenvolvimento de arquiteturas para softwares", 1, 1));

			Profissao profissao1 = profissaoService.getProfissaoById(1L);
			Profissao profissao2 = profissaoService.getProfissaoById(2L);
			Profissao profissao3 = profissaoService.getProfissaoById(3L);

			//Criando Usuarios
			teste = usuarioService.createUsuario(new UsuarioDTO(1L, "Everton", "Jose", "748.682.614-36", "everton7ej@gmail.com", "veve123", "PERM_ADMIN", "03/07/1999", profissao1, 1));
			teste = usuarioService.createUsuario(new UsuarioDTO(2L, "Maria", "Soares", "256.346.596-63", "veveteste1@gmail.com", "123", "PERM_USUARIO", "03/07/1999", profissao1, 1));
			teste = usuarioService.createUsuario(new UsuarioDTO(3L, "Barbara", "Santos", "088.117.483-13", "veveteste2@gmail.com", "123", "PERM_MODERADOR", "03/07/1999", profissao1, 2));
			teste = usuarioService.createUsuario(new UsuarioDTO(4L, "Jose", "Silva", "603.836.852-30", "null1", "nulla", "PERM_USUARIO", "03/07/1999", profissao1, 3));
			teste = usuarioService.createUsuario(new UsuarioDTO(5L, "Bruna", "Lopes", "682.058.527-66", "null2", "nulla", "PERM_USUARIO", "03/07/1999", profissao2, 1));
			teste = usuarioService.createUsuario(new UsuarioDTO(6L, "Armando", "Silva", "424.397.284-20", "null3", "nulla", "PERM_MODERADOR", "03/07/1999", profissao2, 2));
			teste = usuarioService.createUsuario(new UsuarioDTO(7L, "Clóvis", "Santos", "754.767.541-72", "null4", "nulla", "PERM_USUARIO", "03/07/1999", profissao3, 3));
			teste = usuarioService.createUsuario(new UsuarioDTO(8L, "Marta", "Pereira", "948.778.826-34", "null5", "nulla", "PERM_MODERADOR", "03/07/1999", profissao3, 2));

		};

	}
}
