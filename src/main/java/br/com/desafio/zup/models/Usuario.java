package br.com.desafio.zup.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "email", length = 60, nullable = false, unique = true)
    private String email;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(name = "data_nascimento", length = 10, nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
    private List<Vacina> vacinas = new ArrayList<>();

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

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

}
