/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste;

import br.edu.ifsul.modelo.Filmes;
import br.edu.ifsul.modelo.Pessoas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author romulo
 */
public class TestePersistirFilmes {

    public TestePersistirFilmes() {
    }
    
    EntityManagerFactory emf;
    EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Trabalho-Final-TAPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        Filmes f1 = new Filmes();
        f1.setNome("O barco perdido");
        f1.setSnopse("O filme conta historia da maior tragedia de 1912");
        f1.setClassificacao("10 anos");
        f1.setDiretor("James Warter");
        f1.setProdutora("PlayArt");
        f1.setPessoas(em.find(Pessoas.class, "roh-gomes"));
        em.getTransaction().begin();
        em.persist(f1);
        em.getTransaction().commit(); 
        
    }

}