/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author irfan
 */
@Entity
@Table(name = "defect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Defect.FIND_ALL, query = "SELECT d FROM Defect d"),
    @NamedQuery(name = "Defect.findById", query = "SELECT d FROM Defect d WHERE d.id = :id"),
    @NamedQuery(name = "Defect.findByDescription", query = "SELECT d FROM Defect d WHERE d.description = :description"),
    @NamedQuery(name = "Defect.findByNotes", query = "SELECT d FROM Defect d WHERE d.notes = :notes"),
    @NamedQuery(name = "Defect.findByEstimate", query = "SELECT d FROM Defect d WHERE d.estimate = :estimate")})
public class Defect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "notes")
    private String notes;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "estimate")
    private Double estimate;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "severity", referencedColumnName = "id")
    @ManyToOne
    private Severity severity;
    @JoinColumn(name = "priority", referencedColumnName = "id")
    @ManyToOne
    private Priority priority;
    @JoinColumn(name = "pic", referencedColumnName = "id")
    @ManyToOne
    private Pic pic;
    
    // ======================================
    // =             Constants              =
    // ======================================

    public static final String FIND_ALL = "Defect.findAll";    

    public Defect() {
    }

    public Defect(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getEstimate() {
        return estimate;
    }

    public void setEstimate(Double estimate) {
        this.estimate = estimate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Pic getPic() {
        return pic;
    }

    public void setPic(Pic pic) {
        this.pic = pic;
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
        if (!(object instanceof Defect)) {
            return false;
        }
        Defect other = (Defect) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mascova.oecobt.entity.Defect[ id=" + id + " ]";
    }
    
}
