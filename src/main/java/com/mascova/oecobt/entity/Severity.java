/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author irfan
 */
@Entity
@Table(name = "severity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Severity.findAll", query = "SELECT s FROM Severity s"),
    @NamedQuery(name = "Severity.findById", query = "SELECT s FROM Severity s WHERE s.id = :id"),
    @NamedQuery(name = "Severity.findByName", query = "SELECT s FROM Severity s WHERE s.name = :name")})
public class Severity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "severity")
    private Collection<Defect> defectCollection;

    public Severity() {
    }

    public Severity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Defect> getDefectCollection() {
        return defectCollection;
    }

    public void setDefectCollection(Collection<Defect> defectCollection) {
        this.defectCollection = defectCollection;
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
        if (!(object instanceof Severity)) {
            return false;
        }
        Severity other = (Severity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mascova.oecobt.entity.Severity[ id=" + id + " ]";
    }
    
}
