package hibernate.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.model.Department;

public class DemoDepartmentAnnoAction3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session	session = factory.getCurrentSession();
		try {
		session.beginTransaction();
		Department dbean = new Department();
		dbean.setDeptid(12);
	    dbean.setDeptname("嗨囉你好");
	    session.save(dbean);
//	    session.persist(dbean);
		
		session.getTransaction().commit();
		} catch (Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}
//		factory.close();
		HibernateUtil.closeSessionFactory();

	}

}
