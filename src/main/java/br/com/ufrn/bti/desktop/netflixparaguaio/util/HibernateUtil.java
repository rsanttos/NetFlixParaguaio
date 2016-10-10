package br.com.ufrn.bti.desktop.netflixparaguaio.util;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil  
{  
    private static SessionFactory sessionFactory;  
    public static SessionFactory getSessionFactory()  throws MappingException  
    {  
        if(sessionFactory == null) {
            sessionFactory = new Configuration().buildSessionFactory();
        }  
        return sessionFactory;  
    }  
    public static Session getSession()  
    {  
        return getSessionFactory().openSession();  
    }  
}