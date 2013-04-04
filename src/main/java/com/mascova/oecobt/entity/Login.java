/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mascova.oecobt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author irfan
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Login.FIND_ALL, query = "SELECT l FROM Login l"),
    @NamedQuery(name = Login.FIND_BY_LOGIN, query = "SELECT l FROM Login l WHERE l.login = :login")})
public class Login implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Transient
    private String passwordAgain;
    @OneToOne
    @JoinColumn(name = "pic_id")
    private Pic pic;
    // ======================================
    // =             Constants              =
    // ======================================
    public static final String FIND_ALL = "Login.findAll";
    public static final String FIND_BY_LOGIN = "Login.findByLogin";

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the passwordAgain
     */
    public String getPasswordAgain() {
        return passwordAgain;
    }

    /**
     * @param passwordAgain the passwordAgain to set
     */
    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    /**
     * @return the pic
     */
    public Pic getPic() {
        return pic;
    }

    /**
     * @param pic the pic to set
     */
    public void setPic(Pic pic) {
        this.pic = pic;
    }
}
