package br.com.desafio.zup.dto;

import br.com.desafio.zup.models.Usuario;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 7518596221838559448L;
    private Integer id;

    @NotBlank
    @Length(max = 60)
    private String nome;

    @Email
    @Length(max = 60)
    private String email;

    @CPF
    @Length(max = 14)
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static UsuarioDTO convertBy(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.id = usuario.getId();
        usuarioDTO.nome = usuario.getNome();
        usuarioDTO.cpf = usuario.getCpf();
        usuarioDTO.email = usuario.getEmail();
        usuarioDTO.dataNascimento = usuario.getDataNascimento();

        return usuarioDTO;
    }
}
