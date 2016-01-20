/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Samuel
 */
public class JPAUtil {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livraira4PU");
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
}
