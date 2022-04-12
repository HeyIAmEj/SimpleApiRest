package com.heyiamej.project.repository;

import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select p from Usuario p where p.profissao = ?1 and p.nivel = ?2")
    List<Usuario> findusuariosByProfissaoAndNivel(int profissao, int nivel);

    @Query("select user from Usuario user where user.email = ?1 and user.senha = ?2")
    Usuario auth(String email, String senha);

    @Query("select user from Usuario user where user.email = ?1")
    Usuario findByEmail(String email);

}