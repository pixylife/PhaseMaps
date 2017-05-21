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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "beacon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beacon.findAll", query = "SELECT b FROM Beacon b")
    , @NamedQuery(name = "Beacon.findByIdBeacon", query = "SELECT b FROM Beacon b WHERE b.idBeacon = :idBeacon")
    , @NamedQuery(name = "Beacon.findBySubject", query = "SELECT b FROM Beacon b WHERE b.subject = :subject")
    , @NamedQuery(name = "Beacon.findByDescription", query = "SELECT b FROM Beacon b WHERE b.description = :description")})
public class Beacon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBeacon")
    private Integer idBeacon;
    @Size(max = 100)
    @Column(name = "subject")
    private String subject;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "Advertiser_idadvertiser", referencedColumnName = "idadvertiser")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Advertiser advertiseridadvertiser;
    @Transient
    private long latitude;
    @Transient
    private long longitude;

    public Beacon() {
    }

    public Beacon(Integer idBeacon) {
        this.idBeacon = idBeacon;
    }

    public Integer getIdBeacon() {
        return idBeacon;
    }

    public void setIdBeacon(Integer idBeacon) {
        this.idBeacon = idBeacon;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Advertiser getAdvertiseridadvertiser() {
        return advertiseridadvertiser;
    }

    public void setAdvertiseridadvertiser(Advertiser advertiseridadvertiser) {
        this.advertiseridadvertiser = advertiseridadvertiser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBeacon != null ? idBeacon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beacon)) {
            return false;
        }
        Beacon other = (Beacon) object;
        if ((this.idBeacon == null && other.idBeacon != null) || (this.idBeacon != null && !this.idBeacon.equals(other.idBeacon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.technobratz.phasemaps.database.entity.Beacon[ idBeacon=" + idBeacon + " ]";
    }

    /**
     * @return the latitude
     */
    public long getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public long getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

}
