package com.ssh;

import com.ssh.entity.Dept;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static ClassPathXmlApplicationContext act = null;
    private static SessionFactory sessionFactory  = null;
    static{
        act = new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory  = (SessionFactory) act.getBean("sqlSessionFactory");
    }
    @org.junit.Test
    public void fun1(){
        Session session1 = sessionFactory.openSession();
        Session session2 = sessionFactory.openSession();
    }
    //jfsdkf
    @org.junit.Test
    public void fun2(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            Dept dept = new Dept(1, "aaa", "aaa");
            session.persist(dept);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            tx=null;
            session.close();
        }
    }
}
