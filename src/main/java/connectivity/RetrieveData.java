package connectivity;

import entity.Employee;
import org.hibernate.Session;
import utility.HibernateUtility;

/*
Session#get() → This method return a persistence object of the given class with the given identifier. It will return null if there is no persistence object.

Session#load() → This method return a persistence object of the given class with the given identifier. It will throw an exception ObjectNotFoundException, if an entity does not exist in the database. The load() method may return a proxy object instead of a real persistence object.

Session#byId() → This method is used to obtain a persistence object by it primary identifier.

*/

public class RetrieveData {
    public static void main(String[] args) {
        try(Session session= HibernateUtility.getSessionFactory().openSession()){

            //begin a transaction
            session.beginTransaction();

            //get to be persisted data.
            Employee e1= session.get(Employee.class,3);

            System.out.println(e1!=null?e1.getEmpName():"Not found");

            Employee e2= session.load(Employee.class,3);

            System.out.println(e1!=null?e2.getEmpName():"Not found");

            //commit data
            session.getTransaction().commit();

            //shutdown
            HibernateUtility.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
