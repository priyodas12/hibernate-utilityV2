package connectivity;

import entity.Employee;
import org.hibernate.Session;
import utility.HibernateUtility;

public class PersistData {
    public static void main(String[] args) {
        try(Session session= HibernateUtility.getSessionFactory().openSession()){
            //get to be persisted data.
            Employee e= TestEmployeeData.getTestEmployee();

            //begin a transaction
            session.beginTransaction();

            //


            //shutdown
            HibernateUtility.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}