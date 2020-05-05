package hibernate.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import hibernate.model.HouseBean;
import hibernate.model.HouseBeanDAO;
import hibernate.model.IHouseBean;
import hibernate.service.HouseBeanService;

public class DemoHouseBeanServiceAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			HouseBeanService hService = new HouseBeanService(session);
//			hService.delete(1001);
			HouseBean hb = new HouseBean();
			hb.setHouseid(1001);
			hb.setHousename("micky house");
			hService.insert(hb);

			session.getTransaction().commit();
		} catch (Exception exception) {
			session.getTransaction().rollback();
			exception.printStackTrace();
		}

		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
