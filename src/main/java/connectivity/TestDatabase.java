package connectivity;

import org.hibernate.Session;
import utility.HibernateUtility;

public class TestDatabase {
    public static void main(String[] args) {
        try(Session session=HibernateUtility.getSessionFactory().openSession()){
            String SQL="SELECT VERSION()";
            String vMySQL=(String)session.createNativeQuery(SQL).getSingleResult();
            System.out.println("Current SQL version::"+vMySQL);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
