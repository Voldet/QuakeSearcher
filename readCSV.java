package project;

import java.io.*;
import java.util.ArrayList;

public class readCSV{
	public static ArrayList<String> readCSVFile(String filePath){
	File csv = new File(filePath);  // CSV文件路径
    BufferedReader br = null;
    try
    {
        br = new BufferedReader(new FileReader(csv));
    } catch (FileNotFoundException e1)
    {
        e1.printStackTrace();
    }
    String line = "";
    try {	
            ArrayList<String> allString = new ArrayList<>();
            while ((line = br.readLine()) != null)  
            	//读取到的内容给line变量
            {
                allString.add(line);
                //将每一行的地震数据填入一个ArrayList当中（前提是每组地震数据能完整的显示在每一行当中）
            }
            return allString;
    } catch (IOException e)
    {
        e.printStackTrace();
    }
	return null;
	}

}
