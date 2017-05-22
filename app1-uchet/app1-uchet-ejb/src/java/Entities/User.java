
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;


@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    
    @Column(name = "fio")
    private String fio;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "rolename")
    private String rolename;
    
    @JoinColumn(name="studid")
    @ManyToMany(mappedBy="studingroup",cascade=CascadeType.MERGE)
    private List<Studgroup> studgroup;
    
    public void addStudgroup(Studgroup studgroup){ // for MANYtoMANY
        this.studgroup.add(studgroup);
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<GrantUser> grantUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Statement> statementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Mark> markList;
    
    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(int idUser, String fio, String email, String password, String rolename) {
        this.idUser = idUser;
        this.fio = fio;
        this.email = email;
        this.password = password;
        this.rolename = rolename;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @XmlTransient
    public List<GrantUser> getGrantUserList() {
        return grantUserList;
    }

    public void setGrantUserList(List<GrantUser> grantUserList) {
        this.grantUserList = grantUserList;
    }

    @XmlTransient
    public List<Statement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<Statement> statementList) {
        this.statementList = statementList;
    }

    @XmlTransient
    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }

    @Override
    public String toString() {
        return "Entities.User[ idUser=" + idUser + " ]";
    }

    /**
     * @return the studgroup
     */
    public List<Studgroup> getStudgroup() {
        return studgroup;
    }

    /**
     * @param studgroup the studgroup to set
     */
    public void setStudgroup(List<Studgroup> studgroup) {
        this.studgroup = studgroup;
    }
    
}
