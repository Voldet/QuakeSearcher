package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Author Vold
 */
public class Creeper {
	String addr = "earthquakes-1.sqlite";
	private String databaseType = "org.sqlite.JDBC";
    private String databaseSource = "jdbc:sqlite:" + addr;
    private Connection connection = null;
	/**
	 * To spider the web earthquake into the database
	 * @throws IOException
	 */
	public void getCreep() throws IOException {
		ArrayList<String> allQuake = new ArrayList<String>();
		try{
        	
            Class.forName(databaseType);
            
        }catch (Exception e){
        	
        	System.err.println("DatabaseType is not correct");
            e.printStackTrace();    
        }
		
		for (int page = 1; page < 3 ; page++) {
			String web = "https://www.emsc-csem.org/Earthquake/?view=" +page;
			Document doc = Jsoup.connect(web).get();
			/**
			 * Print web to make User easy to find the website
			*/
			System.out.println(web);
			Elements tables = doc.select("tr[class~=ligne(1|2)]");
			for (Element rows : tables) {
				Elements cols = rows.select("td[class~=(tabev[1-6])|(tb_region)]");
				try {
					String eachQuake = "";
					/*
					 * Each for loop will get a SQlite statement
					 * */
					for (int i = 0; i < cols.size(); i++) {
						
						Element a = cols.get(i);
						if (eachQuake.isEmpty()||eachQuake==null) {
							eachQuake+="insert or ignore into quakes values(" + rows.id() + ",datetime('";
						}
						if (i == 0) {
							eachQuake += "" + a.selectFirst("a").text() + "'),";
						} else if (i == 8) {
							eachQuake += "\"" + a.text() + "\""+","+0+")";
						} else if (i == 1 || i == 3) {
							if (Pattern.matches("S|W", cols.get(i + 1).text())) {
								eachQuake += "-" + a.text()+",";
							} else {
								eachQuake += a.text()+",";
							}
							i++;
						} else if (i != 6) {
							eachQuake+=a.text()+",";
						}
						
					}
					System.out.println(eachQuake);
					allQuake.add(eachQuake);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		 try{
			 	connection = DriverManager.getConnection(databaseSource);
	            Statement stm = connection.createStatement();
	            /*
	             * Execute all the SQlite statements 
	             * */
	            for(String sql : allQuake){
	            	stm.executeUpdate(sql);
	            }
	            System.err.println("Insert rencent earthquake successfully");
	            stm.close();
	            connection.close();
	        }catch (Exception e){
	        	System.err.println("Cannot find the driver or the database source is not corrected");
	            e.printStackTrace();
	            
	        }
		
	}
	
}
