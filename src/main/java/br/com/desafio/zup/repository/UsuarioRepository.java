package br.com.desafio.zup.repository;

import br.com.desafio.zup.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByEmailOrCpf(String email, String cpf);
}
