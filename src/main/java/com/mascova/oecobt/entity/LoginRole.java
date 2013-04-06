/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author irfan
 */
@Entity
@Table(name = "loginrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginRole.findAll", query = "SELECT l FROM LoginRole l"),
    @NamedQuery(name = "LoginRole.findById", query = "SELECT l FROM LoginRole l WHERE l.id = :id"),
    @NamedQuery(name = "LoginRole.findByLoginid", query = "SELECT l FROM LoginRole l WHERE l.loginRolePK.loginid = :loginid"),
    @NamedQuery(name = "LoginRole.findByRoleid", query = "SELECT l FROM LoginRole l WHERE l.loginRolePK.roleid = :roleid"),
    @NamedQuery(name = "LoginRole.findByName", query = "SELECT l FROM LoginRole l WHERE l.name = :name")})
public class LoginRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LoginRolePK loginRolePK;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Size(max = 75)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "roleid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumn(name = "loginid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Login login;

    public LoginRole() {
    }

    public LoginRole(LoginRolePK loginRolePK) {
        this.loginRolePK = loginRolePK;
    }

    public LoginRole(LoginRolePK loginRolePK, int id) {
        this.loginRolePK = loginRolePK;
        this.id = id;
    }

    public LoginRole(int loginid, int roleid) {
        this.loginRolePK = new LoginRolePK(loginid, roleid);
    }

    public LoginRolePK getLoginRolePK() {
        return loginRolePK;
    }

    public void setLoginRolePK(LoginRolePK loginRolePK) {
        this.loginRolePK = loginRolePK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginRolePK != null ? loginRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginRole)) {
            return false;
        }
        LoginRole other = (LoginRole) object;
        if ((this.loginRolePK == null && other.loginRolePK != null) || (this.loginRolePK != null && !this.loginRolePK.equals(other.loginRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mascova.oecobt.entity.LoginRole[ loginRolePK=" + loginRolePK + " ]";
    }
    
}
