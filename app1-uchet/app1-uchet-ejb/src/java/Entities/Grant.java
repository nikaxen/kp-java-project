
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "grant", catalog = "uchet", schema = "")
@XmlRootElement
public class Grant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grant")
    private Integer idGrant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "grant_semestr")
    private String grantSemestr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "grant_title")
    private String grantTitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grant")
    private List<GrantUser> grantUserList;

    public Grant() {
    }

    public Grant(Integer idGrant) {
        this.idGrant = idGrant;
    }

    public Grant(Integer idGrant, String grantSemestr, String grantTitle) {
        this.idGrant = idGrant;
        this.grantSemestr = grantSemestr;
        this.grantTitle = grantTitle;
    }

    public Integer getIdGrant() {
        return idGrant;
    }

    public void setIdGrant(Integer idGrant) {
        this.idGrant = idGrant;
    }

    public String getGrantSemestr() {
        return grantSemestr;
    }

    public void setGrantSemestr(String grantSemestr) {
        this.grantSemestr = grantSemestr;
    }

    public String getGrantTitle() {
        return grantTitle;
    }

    public void setGrantTitle(String grantTitle) {
        this.grantTitle = grantTitle;
    }

    @XmlTransient
    public List<GrantUser> getGrantUserList() {
        return grantUserList;
    }

    public void setGrantUserList(List<GrantUser> grantUserList) {
        this.grantUserList = grantUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrant != null ? idGrant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grant)) {
            return false;
        }
        Grant other = (Grant) object;
        if ((this.idGrant == null && other.idGrant != null) || (this.idGrant != null && !this.idGrant.equals(other.idGrant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Grant[ idGrant=" + idGrant + " ]";
    }
    
}
