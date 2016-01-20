/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.DAO;

import br.com.livraria.entitys.Autor;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Samuel
 */
public class AutorDAO {

    public List<Autor> listaTodos(EntityManager em) {

        String hql = Autor.FIND_ALL;
//                "SELECT a FROM Autor a";
        List<Autor> listaAutores = 
                em.createNamedQuery("Autor.findAll", Autor.class).getResultList();
//                        createQuery(Autor.FIND_ALL, Autor.class)
//                        .getResultList();
         
        return listaAutores;
    }

    public void insereAutor(Autor autorASerInserido, EntityManager em) {
        em.persist(autorASerInserido);
    }

    public void removeAutor(Autor autorParaRemover, EntityManager em) {
        em.remove(autorParaRemover);
    }

    public Autor buscaAutor(Autor autorPesquisado, EntityManager em) {
        return em.find(Autor.class, autorPesquisado.getId());
    }
    
    public Autor atualizaAutor (Autor autorPesquisado, EntityManager em){
        return em.merge(autorPesquisado);
    }

}
