/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.livraria.DAO.AutorDAO;
import br.com.livraria.entitys.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Samuel
 */
public class TesteJPA {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("Livraira4PU");
        EntityManager em = emf.createEntityManager();

        AutorDAO dao = new AutorDAO();
        
        em.getTransaction().begin();
        
        
        
        List<Autor> listaAutores = dao.listaTodos(em);
        
        System.out.println("Imprimindo Dados do Autor");
        
        for (Autor autor : listaAutores) {
            System.out.println("nome: " + autor.getNome());
        }
        
        //fecha
        em.getTransaction().commit();
        em.close();
                
    }
}
