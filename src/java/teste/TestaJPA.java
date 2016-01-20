/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.livraria.DAO.AutorDAO;
import br.com.livraria.entitys.Autor;
import br.com.livraria.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author SamuelI
 */
public class TestaJPA {
    
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        AutorDAO dao = new AutorDAO();
        List<Autor> lista = dao.listaTodos(em);
        
        //executa e fecha a instrucao
        em.getTransaction().commit();
        em.close();
    }
}
