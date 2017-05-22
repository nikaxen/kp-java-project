
package DAO;

import Entities.Grant;
import Entities.GrantUser;
import Entities.Mark;
import Entities.Statement;
import Entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GrantDAO {
    public void AddNewGrant(String grant_semestr, String grant_title);
    public List<GrantUser> getGrantDetails(String semcode);
    public List<Grant> getAllGrants();
    public void GrantCalculate();
}
