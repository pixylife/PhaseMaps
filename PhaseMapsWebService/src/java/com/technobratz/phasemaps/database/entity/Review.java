/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobratz.phasemaps.database.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thushini Ranasinghe
 */
@Entity
@Table(name = "reveiw", catalog = "phaseMaps", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reveiw.findAll", query = "SELECT r FROM Reveiw r")
    , @NamedQuery(name = "Reveiw.findById", query = "SELECT r FROM Reveiw r WHERE r.id = :id")
    , @NamedQuery(name = "Reveiw.findByDescription", query = "SELECT r FROM Reveiw r WHERE r.description = :description")})
public class Reveiw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 200)
    @Column(name = "description", length = 200)
    private String description;
    @JoinColumn(name = "Location_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Location locationid;

    public Reveiw() {
    }

    public Reveiw(Integer id) {
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

    public Location getLocationid() {
        return locationid;
    }

    public void setLocationid(Location locationid) {
        this.locationid = locationid;
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
        if (!(object instanceof Reveiw)) {
            return false;
        }
        Reveiw other = (Reveiw) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.technobratz.phasemaps.database.entity.Reveiw[ id=" + id + " ]";
    }
    
}
