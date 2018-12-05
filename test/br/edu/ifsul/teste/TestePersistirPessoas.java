/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste;

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
public class TestePersistirPessoas {
    
    public TestePersistirPessoas() {
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
        
        Pessoas p1 = new Pessoas();
        p1.setNome("Rômulo Gomes");
        p1.setCpf("04909299408");
        p1.setLogin("roh-gomes");
        p1.setSenha("teste1234"); 
        
        Pessoas p2 = new Pessoas();
        p2.setNome("Franciele Serena");
        p2.setCpf("01266163026");
        p2.setLogin("fran-serena");
        p2.setSenha("123456789");
        em.getTransaction().begin();
        em.persist(p2);
        em.persist(p1);
        em.getTransaction().commit();        
    }
}
