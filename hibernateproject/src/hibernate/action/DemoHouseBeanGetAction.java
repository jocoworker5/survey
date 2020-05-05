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

public class DemoHouseBeanGetAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		

		try {
			session.beginTransaction();
			HouseBean houseBean1 = new HouseBean();
			houseBean1.setHouseid(1002);
			houseBean1.setHousename("Fashion Flag");
			session.save(houseBean1);
			HouseBean houseBean2 = new HouseBean();
			houseBean2.setHouseid(1003);
			houseBean2.setHousename("modern Flag");
			session.save(houseBean2);
			HouseBean houseBean3 = new HouseBean();
			houseBean3.setHouseid(1004);
			houseBean3.setHousename("wheel Flag");
			session.save(houseBean3);
			
			
			HouseBean houseBean = session.get(HouseBean.class, 1001); // load找不到資料會顯示錯誤

			if (houseBean != null) {
				System.out.println("houseid=" + houseBean.getHouseid() + "  ,housename=" + houseBean.getHousename());

			} else {
				System.out.println("no data");
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
