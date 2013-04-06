/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author irfan
 */
@Embeddable
public class LoginRolePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginid")
    private int loginid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roleid")
    private int roleid;

    public LoginRolePK() {
    }

    public LoginRolePK(int loginid, int roleid) {
        this.loginid = loginid;
        this.roleid = roleid;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) loginid;
        hash += (int) roleid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginRolePK)) {
            return false;
        }
        LoginRolePK other = (LoginRolePK) object;
        if (this.loginid != other.loginid) {
            return false;
        }
        if (this.roleid != other.roleid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mascova.oecobt.entity.LoginRolePK[ loginid=" + loginid + ", roleid=" + roleid + " ]";
    }
    
}
