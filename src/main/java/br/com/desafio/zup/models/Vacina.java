package br.com.desafio.zup.models;

import br.com.desafio.zup.dto.VacinaDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "data_aplicacao", length = 10, nullable = false)
    private LocalDate dataAplicacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

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

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Vacina convertBy(VacinaDTO vacinaDTO, Usuario usuario){
        Vacina vacina = new Vacina();

        vacina.nome = vacinaDTO.getNome();
        vacina.dataAplicacao = vacinaDTO.getDataAplicacao();
        vacina.usuario = usuario;

        return vacina;
    }
}
