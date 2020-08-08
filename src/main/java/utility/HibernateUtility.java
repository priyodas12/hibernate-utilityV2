package utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;


import java.util.HashMap;
import java.util.Map;

/*
* ServiceRegistry: The central service API, aside from the services themselves, is the org.hibernate.service.ServiceRegistry interface. The main purpose of a service registry is to hold, manage and provide access to services.
* MetadataSources: Entry point into working with sources of metadata information (mapping XML, annotations). Tell Hibernate about sources and then call buildMetadata(), or use getMetadataBuilder() to customize how sources are processed (naming strategies, etc).
*
*
* we are not deleting hibernate.cfg.xml for future ref;
*/

public class HibernateUtility {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    //get session factory in static block.
    static{
        if(sessionFactory == null) {
            try {
                // Create registry with hibernate.cfg.xml,configure() will load default settings
                //standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

                StandardServiceRegistryBuilder standardServiceRegistryBuilder=new StandardServiceRegistryBuilder();

                //hibernate connectivity data counter part of hibernate.cfg.xml;
                Map<String ,String> mysqlDbSettingsInfo=new HashMap<>();
                //mysql driver info
                mysqlDbSettingsInfo.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
                //pointing database url
                mysqlDbSettingsInfo.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate_db");
                //username
                mysqlDbSettingsInfo.put(Environment.USER,"root");
                //password
                mysqlDbSettingsInfo.put(Environment.PASS,"Priyo123");
                //dialect will be creating database specific query
                mysqlDbSettingsInfo.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
                //each trigger will create table
                mysqlDbSettingsInfo.put(Environment.HBM2DDL_AUTO,"CREATE");

                //apply mysql database setting
                standardServiceRegistryBuilder.applySettings(mysqlDbSettingsInfo);

                //create registry
                standardServiceRegistry=standardServiceRegistryBuilder.build();

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
