package hibernate.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseBeanDAO implements IHouseBean {

	private Session  session;

	public HouseBeanDAO(Session session) {
		this.session=session;
	}
    
	
	@Override
	public HouseBean insert(HouseBean hb) {
		HouseBean houseBean = session.get(HouseBean.class, hb.getHouseid());
		if(houseBean==null) {
			session.save(hb);
			return hb;
		}
		return null;
	}
	
	@Override
	public HouseBean select(int houseid) {
		HouseBean houseBean = session.get(HouseBean.class, houseid);
		return houseBean;		
	}
	
	@Override
	public List<HouseBean> selectAll(){
		Query<HouseBean> createQuery = session.createQuery("from HouseBean",HouseBean.class);
		List<HouseBean> list = createQuery.list();
		return list;
	}
	
	@Override
	public HouseBean update(String housename, int houseid) {
		HouseBean hb = session.get(HouseBean.class, houseid);
		if(hb!=null) {
			hb.setHousename(housename);
			return hb;
		}
	    return null;	
	}
	
	@Override
	public boolean delete(int houseid) {
		
		HouseBean hb = session.get(HouseBean.class, houseid);
		if(hb!=null) {
			session.delete(hb);
			return true;
		}
		return false;
	}
}
