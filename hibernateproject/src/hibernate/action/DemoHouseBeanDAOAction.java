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

public class DemoHouseBeanDAOAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		

		try {
			session.beginTransaction();
			//insert
//			HouseBean houseBean1 = new HouseBean();
//			houseBean1.setHouseid(1005);
//			houseBean1.setHousename("Fashion Flag");
//			HouseBeanDAO dao = new HouseBeanDAO(session);
//			dao.insert(houseBean1);
			
			//select 
//			HouseBeanDAO dao = new HouseBeanDAO(session);
//			HouseBean hb = dao.select(1005);
//			System.out.println(hb.getHouseid()+" "+hb.getHousename());
//			
			//selectAll
			IHouseBean dao = new HouseBeanDAO(session);
			List<HouseBean> selectAll = dao.selectAll();
			for(HouseBean hb:selectAll) {
				System.out.println(hb.getHouseid()+" "+hb.getHousename());
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
