package hibernate.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.model.Department;

public class DemoDepartmentAnnoAction2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session	session = factory.openSession();
		Transaction	ts = session.beginTransaction();
		
		Department dbean = new Department();
	    dbean.setDeptname("71-11");
	    session.save(dbean);
		
		ts.commit();
		session.close();
//		factory.close();
		HibernateUtil.closeSessionFactory();

	}

}
