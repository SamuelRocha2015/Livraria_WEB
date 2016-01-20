/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "autor")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Autor.findAll",query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findById",query= "SELECT a FROM Autor a WHERE a.id = :id"),
    @NamedQuery(name = "Autor.findByNome",query= "SELECT a FROM Autor a WHERE a.nome = :nome")})

public class Autor implements Serializable {
    
    public static final String FIND_ALL = "Autor.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer codigo;
    @Column(name = "NOME")
    private String nome;
    @OneToMany(mappedBy = "autor")
    private List<Livro> livroList;

    public Autor() {
    }

    public Autor(Integer id) {
        this.codigo = id;
    }

    public Integer getId() {
        return codigo;
    }

    public void setId(Integer id) {
        this.codigo = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Livro> getLivroList() {
        return livroList;
    }

    public void setLivroList(List<Livro> livroList) {
        this.livroList = livroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the codigo fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.livraria.entitys.Autor[ id=" + codigo + " ]";
    }

}
