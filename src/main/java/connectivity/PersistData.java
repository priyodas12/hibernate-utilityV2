package connectivity;

import entity.Employee;
import org.hibernate.Session;
import utility.HibernateUtility;

public class PersistData {
    public static void main(String[] args) {
        try(Session session= HibernateUtility.getSessionFactory().openSession()){
            //get to be persisted data.
            Employee e1= TestEmployeeData.getTestEmployee().get(0);
            Employee e2= TestEmployeeData.getTestEmployee().get(1);

            //begin a transaction
            session.beginTransaction();

            //save data in session,returns primary key
            Integer pk= (Integer) session.save(e1);

            //persist method return type is void;
            session.persist(e2);

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
