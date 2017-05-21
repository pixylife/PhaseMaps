/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobratz.phasemaps.database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "advertiser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertiser.findAll", query = "SELECT a FROM Advertiser a")
    , @NamedQuery(name = "Advertiser.findByIdadvertiser", query = "SELECT a FROM Advertiser a WHERE a.idadvertiser = :idadvertiser")
    , @NamedQuery(name = "Advertiser.findByName", query = "SELECT a FROM Advertiser a WHERE a.name = :name")
    , @NamedQuery(name = "Advertiser.findByEmail", query = "SELECT a FROM Advertiser a WHERE a.email = :email")
    , @NamedQuery(name = "Advertiser.findByContactNo", query = "SELECT a FROM Advertiser a WHERE a.contactNo = :contactNo")
    , @NamedQuery(name = "Advertiser.findByAddress", query = "SELECT a FROM Advertiser a WHERE a.address = :address")
    , @NamedQuery(name = "Advertiser.findByCompany", query = "SELECT a FROM Advertiser a WHERE a.company = :company")
    , @NamedQuery(name = "Advertiser.findByPassword", query = "SELECT a FROM Advertiser a WHERE a.password = :password")})
public class Advertiser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idadvertiser")
    private Integer idadvertiser;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "contactNo")
    private String contactNo;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    @Size(max = 150)
    @Column(name = "company")
    private String company;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advertiseridadvertiser", fetch = FetchType.LAZY)
    private Collection<Beacon> beaconCollection;

    public Advertiser() {
    }

    public Advertiser(Integer idadvertiser) {
        this.idadvertiser = idadvertiser;
    }

    public Integer getIdadvertiser() {
        return idadvertiser;
    }

    public void setIdadvertiser(Integer idadvertiser) {
        this.idadvertiser = idadvertiser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Beacon> getBeaconCollection() {
        return beaconCollection;
    }

    public void setBeaconCollection(Collection<Beacon> beaconCollection) {
        this.beaconCollection = beaconCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadvertiser != null ? idadvertiser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertiser)) {
            return false;
        }
        Advertiser other = (Advertiser) object;
        if ((this.idadvertiser == null && other.idadvertiser != null) || (this.idadvertiser != null && !this.idadvertiser.equals(other.idadvertiser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.technobratz.phasemaps.database.entity.Advertiser[ idadvertiser=" + idadvertiser + " ]";
    }
    
}
