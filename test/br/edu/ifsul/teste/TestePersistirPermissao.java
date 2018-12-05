/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Pessoas;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author romulo
 */
public class TestePersistirPermissao {

    public TestePersistirPermissao() {
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
        Permissao obj = new Permissao();
        obj.setNome("ADMINISTRADOR");
        obj.setDescricao("Administradores do sistema");
        Permissao obj2 = new Permissao();
        obj2.setNome("USUARIO");
        obj2.setDescricao("Usuário do sistema");
        em.getTransaction().begin();
        em.persist(obj);
        em.persist(obj2);
        em.getTransaction().commit();        
    }

}