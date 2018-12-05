/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author romulo
 */
@Entity
@Table(name = "pessoas")
public class Pessoas implements Serializable{
    
   
    @Id
    @NotNull(message = "O login não pode ser nulo")
    @NotBlank(message = "O login não pode estar em branco")
    @Length(max = 50, message = "O login não pode ter mais que {max} caracteres")
    @Column(name = "login", length = 50, nullable = false, unique = true)
    private String login;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O CPF não pode ser nulo")
    @CPF(message = "O CPF não é Valido")
    @NotBlank(message = "O CPF não pode estar em branco")
    @Length(max = 11, message = "O CPF não pode ter mais que {max} caracteres")
    @Column(name = "cpf", length = 50, nullable = false)
    private String cpf;
    
    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A Senha não pode estar em branco")
    @Length(max = 10, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;
    
    @ManyToMany
    @JoinTable(name = "permissoes",
            joinColumns = 
            @JoinColumn(name = "pessoa", referencedColumnName = "login", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();
    
    public Pessoas(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoas other = (Pessoas) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

   

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    
}
