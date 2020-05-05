package hibernate.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import hibernate.model.HouseBean;

public class DemoHouseBeanQueryAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
			List<HouseBean> list = query.list();
			for (HouseBean hb : list) {
				System.out.println(hb.getHouseid() + " " + hb.getHousename());
			}
			for (int i=0; i<list.size(); i++) {
				HouseBean hb = list.get(i);
				System.out.println(hb.getHouseid() + " " + hb.getHousename());
			}
			
			Iterator<HouseBean> iterator = list.iterator();
			while(iterator.hasNext()) {
				HouseBean hb = iterator.next();
				System.out.println(hb.getHouseid() + " " + hb.getHousename());	
			}

			session.getTransaction().commit();
		} catch (Exception exception) {
			session.getTransaction().rollback();
			exception.printStackTrace();
		}

		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
