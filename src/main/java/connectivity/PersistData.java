package connectivity;

import entity.Employee;
import org.hibernate.Session;
import utility.HibernateUtility;
/*
Session#save() → This method is used save an entity/object into database and return a generated identifier. It will throw an exception if an entity already exists in the database.

Session#persist() → This method is used save an entity/object into database and return a void. It will throw an exception if an entity already exists in the database.

Session#saveOrUpdate() → This method is used to either save or update an entity in the database.

*/

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
