package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.Earthquake;
import controller.FilterController;
import service.SqlFixerImpl;

/**
 * Author Vold
 */
public class ReaderDatabaseAll  implements Reader {
	private String databaseType = "org.sqlite.JDBC";
    private String databaseSource = "jdbc:sqlite:earthquakes-1.sqlite";
    private Connection connection = null;
    private String sql = "select * FROM quakes";

    private ArrayList<Earthquake> earthquakeList = new ArrayList<Earthquake>();
    private SqlFixerImpl fixer = new SqlFixerImpl();

    /**
     * To get all the database earthquake information
     * @see dao.Reader#getEarthquakeList()
     */
    @Override
    public ArrayList<Earthquake> getEarthquakeList() {
        return null;
    }
    
    public ArrayList<Earthquake> getEarthquakeList(FilterController filter) {
    	String fixedSql = fixer.fixAll(sql,filter.test());
        try{       	
            Class.forName(databaseType);
        	
            connection = DriverManager.getConnection(databaseSource);
            connection.setAutoCommit(false);
            System.err.println("Successfully connected to the database.");
            
            Statement stm = connection.createStatement();
            stm.setQueryTimeout(300);
            ResultSet result = stm.executeQuery(fixedSql);
            earthquakeList.clear();
            
            while (result.next()){
                Earthquake earthquake = new Earthquake();
                try {
                    earthquake.setId(result.getInt("id"));
                    earthquake.setUTC_date(Timestamp.valueOf(result.getString("UTC_date")));
                    earthquake.setLatitude(result.getFloat("latitude") );
                    earthquake.setLongitude(result.getFloat("longitude"));
                    earthquake.setDepth(result.getFloat("depth"));
                    earthquake.setMagnitude(result.getFloat("magnitude"));
                    earthquake.setRegion(result.getString("region"));
                    earthquakeList.add(earthquake);       
                }catch (Exception e){          	
                	System.err.println("Cannot find the quakes");
                    e.printStackTrace(); 
                }
            }
            
            result.close();
            connection.close();
            
        }catch (Exception e){
        	System.err.println("Cannot find the driver or the database source is not corrected");
        	System.err.println("Please check it again!");
            e.printStackTrace();   
        }
        return earthquakeList;
    }

}
