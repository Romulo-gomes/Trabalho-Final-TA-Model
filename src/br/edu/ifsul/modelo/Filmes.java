/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author romulo
 */
@Entity
@Table(name="filmes")
public class Filmes implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_filmes", sequenceName = "seq_filmes_id"
            ,allocationSize = 1)
    @GeneratedValue(generator = "seq_filmes", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "A snopse não pode ser nulo")
    @NotBlank(message = "A snopse não pode ser em branco")
    @Column(name = "snopse", nullable = false,columnDefinition = "Text")
    private String snopse;
    
    @NotNull(message = "A classificação não pode ser nulo")
    @NotBlank(message = "A classificação não pode ser em branco")
    @Length(max = 15, message = "A classificação não pode ter mais que {max} caracteres")
    @Column(name = "classificacao", length = 15, nullable = false)
    private String classificacao;
    
    @NotNull(message = "O diretor não pode ser nulo")
    @NotBlank(message = "O diretor não pode ser em branco")
    @Length(max = 40, message = "O diretor não pode ter mais que {max} caracteres")
    @Column(name = "diretor", length = 40, nullable = false)
    private String diretor;
    
    @NotNull(message = "A produtora não pode ser nulo")
    @NotBlank(message = "A produtora não pode ser em branco")
    @Length(max = 40, message = "A produtora não pode ter mais que {max} caracteres")
    @Column(name = "produtora", length = 40, nullable = false)
    private String produtora;
    
    @ManyToOne
    @JoinColumn(name = "pessoas", referencedColumnName = "login", 
            nullable = false, 
            foreignKey = @ForeignKey(name = "fk_pessoas_id"))
    private Pessoas pessoas;
    
    public Filmes(){
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

    public String getSnopse() {
        return snopse;
    }

    public void setSnopse(String snopse) {
        this.snopse = snopse;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }
    
    
}
