package connectivity;

import org.hibernate.Session;
import utility.HibernateUtility;
//this class will test initial connectivity with database;
public class TestDatabase {
    public static void main(String[] args) {
        try(Session session=HibernateUtility.getSessionFactory().openSession()){
            //create SQL query
            String SQL="SELECT VERSION()";
            //execute result
            String vMySQL=(String)session.createNativeQuery(SQL).getSingleResult();
            System.out.println("Current SQL version::"+vMySQL);
            //shutdown
            HibernateUtility.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
