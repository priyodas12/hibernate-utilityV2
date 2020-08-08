package utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtility {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    //get session factory in static block.
    static{
        if(sessionFactory == null) {
            try {
                // Create registry
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

                //Create MetadataSources
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

                //Create Metadata
                Metadata metadata = metadataSources.getMetadataBuilder().build();

                //get session
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                // terminate standardServiceRegistry instance for exception
                if (standardServiceRegistry != null) {
                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                }
            }
        }
    }
    // single end point for getting session
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    // terminate standardServiceRegistry to close all Session factory instance.
    public static void shutdown() {
        System.out.println("Shutting Down");
        if (standardServiceRegistry != null) {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
        sessionFactory.close();
    }
}
