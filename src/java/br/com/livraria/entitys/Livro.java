/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id"),
    @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Livro.findByIsbn", query = "SELECT l FROM Livro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Livro.findByPreco", query = "SELECT l FROM Livro l WHERE l.preco = :preco"),
    @NamedQuery(name = "Livro.findByLancamento", query = "SELECT l FROM Livro l WHERE l.lancamento = :lancamento")})
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ISBN")
    private String isbn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECO")
    private Double preco;
    @Column(name = "LANCAMENTO")
    private String lancamento;
    @JoinColumn(name = "AUTOR", referencedColumnName = "ID")
    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public Livro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.livraria.entitys.Livro[ id=" + id + " ]";
    }
    
}
