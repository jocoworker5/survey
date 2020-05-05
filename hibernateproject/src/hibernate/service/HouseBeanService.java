package hibernate.service;

import java.util.List;

import org.hibernate.Session;

import hibernate.model.HouseBean;
import hibernate.model.HouseBeanDAO;

public class HouseBeanService implements IHouseBeanService {
	HouseBeanDAO uDAO;

	public HouseBeanService(Session session) {
		uDAO = new HouseBeanDAO(session);
	}

	@Override
	public HouseBean insert(HouseBean hb) {
		return uDAO.insert(hb);
	}

	@Override
	public HouseBean select(int houseid) {

		return uDAO.select(houseid);
	}

	@Override
	public List<HouseBean> selectAll() {
	    return uDAO.selectAll();
	}

	@Override
	public HouseBean update(String housename, int houseid) {
	 return uDAO.update(housename, houseid);
	}

	@Override
	public boolean delete(int houseid) {
		return uDAO.delete(houseid);
	}

}
