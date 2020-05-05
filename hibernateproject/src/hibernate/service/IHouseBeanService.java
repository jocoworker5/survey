package hibernate.service;

import java.util.List;

import hibernate.model.HouseBean;

public interface IHouseBeanService {
	HouseBean insert(HouseBean hb);

	HouseBean select(int houseid);

	List<HouseBean> selectAll();

	HouseBean update(String housename, int houseid);

	boolean delete(int houseid);
}
