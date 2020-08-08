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

            //save data in session,returns primary key
            Integer pk= (Integer) session.save(e);

            //persist method return type is void;
            //session.persist(e);

            //commit data
            session.getTransaction().commit();


            System.out.println("employee with id "+pk+" saved");

            //shutdown
            HibernateUtility.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
