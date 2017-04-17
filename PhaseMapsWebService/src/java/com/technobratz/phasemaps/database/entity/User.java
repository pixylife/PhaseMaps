
package com.technobratz.phasemaps.database.entity;

import java.io.Serializable;
import java.util.List;
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
 * @author Thushini Ranasinghe
 */
@Entity
@Table(name = "user", catalog = "phaseMaps", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userName", nullable = false, length = 50)
    private String userName;
    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useruserName", fetch = FetchType.LAZY)
    private List<Favouriteplace> favouriteplaceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useruserName", fetch = FetchType.LAZY)
    private List<Travellog> travellogList;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Favouriteplace> getFavouriteplaceList() {
        return favouriteplaceList;
    }

    public void setFavouriteplaceList(List<Favouriteplace> favouriteplaceList) {
        this.favouriteplaceList = favouriteplaceList;
    }

    @XmlTransient
    public List<Travellog> getTravellogList() {
        return travellogList;
    }

    public void setTravellogList(List<Travellog> travellogList) {
        this.travellogList = travellogList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.technobratz.phasemaps.database.entity.User[ userName=" + userName + " ]";
    }
    
}
