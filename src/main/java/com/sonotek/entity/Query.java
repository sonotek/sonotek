/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonotek.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oguzhan
 */
@Entity
@Table(name = "query")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Query.findAll", query = "SELECT q FROM Query q")
    , @NamedQuery(name = "Query.findByIdQuery", query = "SELECT q FROM Query q WHERE q.idQuery = :idQuery")
    , @NamedQuery(name = "Query.findByQuery", query = "SELECT q FROM Query q WHERE q.query = :query")})
public class Query implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuery")
    private Integer idQuery;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 999)
    @Column(name = "query")
    private String query;

    public Query() {
    }

    public Query(Integer idQuery) {
        this.idQuery = idQuery;
    }

    public Query(Integer idQuery, String query) {
        this.idQuery = idQuery;
        this.query = query;
    }

    public Integer getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(Integer idQuery) {
        this.idQuery = idQuery;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuery != null ? idQuery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Query)) {
            return false;
        }
        Query other = (Query) object;
        if ((this.idQuery == null && other.idQuery != null) || (this.idQuery != null && !this.idQuery.equals(other.idQuery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sonotek.entity.Query[ idQuery=" + idQuery + " ]";
    }
    
}
