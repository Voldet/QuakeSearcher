package controller;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Earthquake;

/**
 * Author Vold
 */
public interface FilterController {
	
    HashMap<String,Object> test();
    ArrayList<Earthquake> getEarthquakeListFilterFromDB() throws Exception;
    ArrayList<Earthquake> getEarthquakeListFromDB() throws Exception;
}