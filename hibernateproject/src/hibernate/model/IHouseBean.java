package hibernate.model;

import java.util.List;

public interface IHouseBean {

	HouseBean insert(HouseBean hb);

	HouseBean select(int houseid);

	List<HouseBean> selectAll();

	HouseBean update(String housename, int houseid);

	boolean delete(int houseid);

}