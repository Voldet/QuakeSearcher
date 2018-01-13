package dao;

import java.util.ArrayList;

import bean.Earthquake;
import controller.FilterController;
/**
 * Author Vold
 */
public interface Reader {
    ArrayList<Earthquake> getEarthquakeList() throws Exception;

	/**
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	
}