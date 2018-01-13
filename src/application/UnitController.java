package application;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import dao.ReaderDatabaseFilter;
import dao.Creeper;
import bean.Earthquake;
import controller.MapController;
import controller.TableController;
import controller.ToggleGroupsImpl;
import controller.FilterControllerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

/**
 * Author Vold
 */
public class UnitController {
	 	@FXML
	    private DatePicker dateFromDatePicker;
	    @FXML
	    private DatePicker dateToDatePicker;
	    @FXML
	    private TextField regionPicker;
	    @FXML
	    private Slider magnitudeMaxSd;
	    @FXML
	    private TableView<Earthquake> table;
	    @FXML
	    private StackPane Mercator;
	    @FXML
	    private StackPane Eckert;
	    @FXML
	    private ToggleGroup source;
	    
	    
	    
	    public UnitController(){}
	    
	    /**
	     * To get the user operations
	     * @param dateFromDatePicker
	     * @param dateToDatePicker
	     * @param region
	     * @param magnitudeMaxSd
	     */
	    public UnitController(DatePicker dateFromDatePicker, 
								DatePicker dateToDatePicker,
				                TextField region,
				                Slider magnitudeMaxSd){
			    this.dateFromDatePicker = dateFromDatePicker;
			    this.dateToDatePicker = dateToDatePicker;
			    this.regionPicker = region;
			    this.magnitudeMaxSd = magnitudeMaxSd;
	    }
	    
	    static ObservableList<Earthquake> quakeList = FXCollections.observableArrayList();
	    static FilterControllerImpl filterControllerImpl = new FilterControllerImpl();
	    /**
	     * Required quakes list
	     */
	    ArrayList<Earthquake> earthquakes = null;
	    /*
	     * To get all the unit controller
	     * */
	    UnitController unitController = null; 
	    /*
	     * To get table controller
	     * */
	    TableController<Earthquake> tableController = null;
	    /**
	     * To get a MERCATOR Map Controller
	     */
	    MapController mapControllerMERCATOR = null;
	    /**
	     * To get a ECKERT_IV Map Controller
	     */
	    MapController mapControllerECKERT_IV = null;
	    /**
	     * To get a toggle Group Controller
	     */
	    ToggleGroupsImpl toggleGroupController = null;
	    /**
	     * To read the database
	     */
	    ReaderDatabaseFilter read_Database = null;
	    /**
	     * To initialize the spider button
	     */
	    Creeper creeper = new Creeper();
	    
	    /**
	     * If mouse enter the primary stage, 
	     * initialize all the required units
	     * @throws Exception 
	     */
	    public void initUnits() throws Exception{
	            earthquakes = filterControllerImpl.getEarthquakeListFromDB();
	        
	        	unitController = new UnitController(dateFromDatePicker, 
						dateToDatePicker,
		                regionPicker,
		                magnitudeMaxSd);
	        	
	            this.tableController = new TableController<Earthquake>(this.table);
	            try {
					this.mapControllerMERCATOR = new MapController(Mercator,"MERCATOR");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					this.mapControllerECKERT_IV = new MapController(Eckert,"ECKERT_IV");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            this.toggleGroupController = new ToggleGroupsImpl(source);
	    }
	    /**
	     * If mouse click the search button then execute this method
	     * This method will get all the data the user has modify in the UI interface
	     * and put it into database to get the filter data which satisfy the UI interface
	     * and it will then refresh the quake list, quake map. 
	     */
	    public void search(MouseEvent e) throws Exception{
        	unitController = new UnitController(dateFromDatePicker, 
					dateToDatePicker,
	                regionPicker,
	                magnitudeMaxSd);
	        HashMap<String, Object> info = unitController.getAllinfo();
	        filterControllerImpl.setValues(
	        		(Timestamp) info.get("dateFrom"), 
	        		(Timestamp)info.get("dateTo"), 
	        		(String)info.get("region"),
	                (float)info.get("magnitudeMax"));
	        
            earthquakes = filterControllerImpl.getEarthquakeListFilterFromDB();
	        
	        quakeList.clear();
	        for (Earthquake quake : earthquakes) {
	            quakeList.add(quake);
	        }
	        refreshTable();
	        refreshMaps();
	    }
	    /**
	     * If mouse click the list button then execute this method
	     * This method will link to all the quake which save in the database
	     * and then it will refresh the quake list, quake map. 
	     */
	    public void listQuake(MouseEvent e) throws Exception{
	    	
	    	earthquakes = filterControllerImpl.getEarthquakeListFromDB();
	        
	        quakeList.clear();
	        for (Earthquake quake : earthquakes) {
	            quakeList.add(quake);
	        }
	        refreshTable();
	        refreshMaps();
	    }
	    /**
	     * If mouse click the spider button then execute this method
	     * This method reflect to the Creep class which save in the dao package
	     */
	    public void creep(MouseEvent e) throws Exception{
	    	creeper.getCreep();
	    }
	    
	    private void refreshTable(){
	        tableController.refresh(quakeList);
	    }

	    private void refreshMaps() throws Exception{
	        mapControllerMERCATOR.refresh(quakeList);
	        mapControllerECKERT_IV.refresh(quakeList);
	    }
	    /**
	     * @return the information HashMap of the require checked by user
	     */
	    public HashMap<String,Object> getAllinfo(){
	        Timestamp dateFrom = (dateFromDatePicker.getValue() != null)
	                ? Timestamp.valueOf(dateFromDatePicker.getValue().atTime(0, 0, 0)): Timestamp.valueOf("2016-01-01 00:00:00.0");
	        Timestamp dateTo = (dateToDatePicker.getValue() != null)
	                ? Timestamp.valueOf(dateToDatePicker.getValue().atTime(23, 59, 59)): Timestamp.valueOf(LocalDateTime.now());
	        String region = (regionPicker.getText() != null && !regionPicker.getText().isEmpty())
	                ? (regionPicker.getText()): null;
	        float magnitudeMax = (float) magnitudeMaxSd.getValue();
	        
	        HashMap<String,Object> info = new HashMap<String,Object>();
	        info.put("dateFrom",dateFrom);
	        info.put("dateTo",dateTo);
	        info.put("region",region);
	        info.put("magnitudeMax",magnitudeMax);
	        return info;
	    }
}
