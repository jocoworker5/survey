package hibernate.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.model.HouseBean;

public class DemoHouseBeanAction {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session	session = factory.openSession();
		Transaction	ts = session.beginTransaction();
		
		HouseBean houseBean = new HouseBean();
		houseBean.setHouseid(1001);
		houseBean.setHousename("Fashion House");
		session.save(houseBean);
		
		ts.commit();
		session.close();
		factory.close();
	}

}
