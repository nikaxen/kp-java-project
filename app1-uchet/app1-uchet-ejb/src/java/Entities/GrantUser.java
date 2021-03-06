
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "grant_user", catalog = "uchet", schema = "")
//@XmlRootElement
public class GrantUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 //   @Basic(optional = false)
    @Column(name = "id_grant_user")
    private Integer idGrantUser;
 //   @Basic(optional = false)
 //   @NotNull
 //   @Size(min = 1, max = 45)
    @Column(name = "grant_status")
    private String grantStatus;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "id_grant", referencedColumnName = "id_grant")
    @ManyToOne(optional = false)
    private Grant grant;

    public GrantUser() {
    }

    public GrantUser(Integer idGrantUser) {
        this.idGrantUser = idGrantUser;
    }

    public GrantUser(Integer idGrantUser, String grantStatus) {
        this.idGrantUser = idGrantUser;
        this.grantStatus = grantStatus;
    }

    public Integer getIdGrantUser() {
        return idGrantUser;
    }

    public void setIdGrantUser(Integer idGrantUser) {
        this.idGrantUser = idGrantUser;
    }

    public String getGrantStatus() {
        return grantStatus;
    }

    public void setGrantStatus(String grantStatus) {
        this.grantStatus = grantStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Grant getGrant() {
        return grant;
    }

    public void setGrant(Grant grant) {
        this.grant = grant;
    }
    /*
    @Override
    public int hashCode() {
    int hash = 0;
    hash += (idGrantUser != null ? idGrantUser.hashCode() : 0);
    return hash;
    }
    
    @Override
    public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof GrantUser)) {
    return false;
    }
    GrantUser other = (GrantUser) object;
    if ((this.idGrantUser == null && other.idGrantUser != null) || (this.idGrantUser != null && !this.idGrantUser.equals(other.idGrantUser))) {
    return false;
    }
    return true;
    }*/

    @Override
    public String toString() {
        return "Entities.GrantUser[ idGrantUser=" + idGrantUser + " ]";
    }
    
}
