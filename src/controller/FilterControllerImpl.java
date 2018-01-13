package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.Earthquake;
import dao.ReaderDatabaseAll;
import dao.ReaderDatabaseFilter;

/**
 * Author Vold
 */
public class FilterControllerImpl implements FilterController{
    private Timestamp dateFrom;
    private Timestamp dateTo;
    private String region;
    private float magnitudeMax;

    
    
    /**
     * @param dateFrom
     * @param dateTo
     * @param region
     * @param magnitudeMax
     */
    public void setValues(Timestamp dateFrom,
		    		Timestamp dateTo, 
		    		String region,
                    float magnitudeMax){
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.region = region;
        this.magnitudeMax = magnitudeMax;
    }
    
    /**
     * To get all information suitable for what user query besides region
     * @see controller.FilterController#getEarthquakeListFilterFromDB()
     */
    public ArrayList<Earthquake> getEarthquakeListFilterFromDB() throws Exception{
        return new ReaderDatabaseFilter().getEarthquakeList(this);
    }
    
    /**
     * To get the all information suitable for what user query except region
     * @see controller.FilterController#getEarthquakeListFromDB()
     */
    public ArrayList<Earthquake> getEarthquakeListFromDB() throws Exception{
        return new ReaderDatabaseAll().getEarthquakeList(this);
    }
    
    
    /**
     * To test if the information is a quake information
     * @see controller.FilterController#test()
     */
    @Override
    public HashMap<String,Object> test(){
        Map<String,Object> conditions = new HashMap<String, Object>();
        conditions.put("dateFrom",dateFrom);
        conditions.put("dateTo",dateTo);
        conditions.put("region", region);
        conditions.put("magnitudeMax",magnitudeMax);
        return (HashMap<String, Object>) conditions;
    }

}