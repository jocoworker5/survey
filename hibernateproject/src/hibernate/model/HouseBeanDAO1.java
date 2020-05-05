package hibernate.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseBeanDAO1 {

	private Session session;

	public HouseBeanDAO1(Session session) {
		this.session = session;
	}
	
	public HouseBean insert(HouseBean hBean) {
		HouseBean houseBean = session.get(HouseBean.class, hBean.getHouseid());
		
		if(houseBean==null) {
			session.save(hBean);
			return hBean;
		}
		
		return null;
	}
	
	public HouseBean select(int houseid) {
		return session.get(HouseBean.class, houseid);
	}
	
	public List<HouseBean> selectAll() {
		Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
        List<HouseBean> list = query.list();
        return list;
	}
	
	public HouseBean update(int houseid, String housename) {
		HouseBean houseBean = session.get(HouseBean.class, houseid);
		if(houseBean!=null) {
			houseBean.setHousename(housename);
		}
		return houseBean;
	}
	
	public boolean delete(int houseid) {
		HouseBean houseBean = session.get(HouseBean.class, houseid);
		if(houseBean!=null) {
			session.delete(houseBean);
			return true;
		}
		return false;
	}
 
}








