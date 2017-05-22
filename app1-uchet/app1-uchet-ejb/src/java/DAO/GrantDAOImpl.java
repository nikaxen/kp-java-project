package DAO;

import Entities.Grant;
import Entities.GrantUser;
import Entities.Mark;
import Entities.Statement;
import Entities.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GrantDAOImpl implements GrantDAO, Serializable {

    @PersistenceContext(unitName = "app1-uchet-ejbPU")
    private EntityManager em;

    @Override
    public void AddNewGrant(String grant_semestr, String grant_title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrantUser> getGrantDetails(String semcode) {
        Query query = em.createQuery("SELECT gu FROM GrantUser gu JOIN gu.grant gr WHERE gr.grantSemestr=?1", GrantUser.class);
        query.setParameter(1, semcode);
        return (List<GrantUser>) query.getResultList();
    }

    @Override
    public void GrantCalculate() { // GRANT CALCULATE method
        // SECOND db
        Query query_grant = em.createQuery("SELECT g FROM Grant g WHERE g.grantSemestr=?1", Grant.class);
        query_grant.setParameter(1, "SPRING2017");
        Grant grant = (Grant) query_grant.getSingleResult();
        // FIRST db (and SECOND too)
        Query query = em.createQuery("SELECT u FROM User u JOIN u.markList ml JOIN ml.statement st WHERE st.semestr='SPRING2017' GROUP BY u.idUser", User.class);
        List<User> uList = query.getResultList();
        boolean grant_status = true;
        for (User u : uList) {
            List<Mark> markList = u.getMarkList();
            for (Mark m : markList) {
                if (u.getIdUser() == m.getUser().getIdUser()) {
                    System.out.println(u.getFio() + " - " + m.getMark());
                    if (m.getMark() < 3) {
                        grant_status = false;
                    }
                }
            }
            // SECOND db
            Grant g = em.find(Grant.class, grant.getIdGrant());
            GrantUser gu = new GrantUser();
            gu.setUser(u);
            gu.setGrant(g);
            // SMTH in the middle
            if (grant_status) {
                System.out.println("ПОЛУЧАЕТ - " + u.getFio());
                gu.setGrantStatus("ok");
            } else {
                System.out.println("НЕ ПОЛУЧАЕТ - " + u.getFio());
                gu.setGrantStatus("no");
            }
            em.persist(gu);
            // FIRST db
            grant_status = true;
            
        }
    }

    @Override
    public List<Grant> getAllGrants() {
        Query query = em.createQuery("SELECT g FROM Grant g", Grant.class);
        return (List<Grant>) query.getResultList();
    }
}
