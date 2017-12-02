package project;

import java.io.*;

public class save extends father_list{
	public static void save_quake() throws IOException{
		File file = new File("C:Users\\machenike\\workspace\\java2\\src\\project");
		if(!file.exists())
			//没有这个file文件则创建一个file文件
			file.mkdirs();
		if(!file.isFile()){
			//判断不是文件则抛出异常
			throw new IllegalArgumentException(file+" is not a file.");
		}
		Writer out = null;
		try {
			out = new FileWriter(file, false);

		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i<quake.size(); i++){
			String id = quake.get(i).getId();
			String UTC_date = quake.get(i).getUTC_date();
			String latitude = quake.get(i).getLatitude();
			String longtitude = quake.get(i).getLongitude();
			String depth = quake.get(i).getDepth();
			String magnitude = quake.get(i).getMagnitude();
			String region = quake.get(i).getRegion();
			region += "\r\n";
			//每写入一行地震数据，执行换行操作
			out.write(id+","+UTC_date+","+latitude+","+longtitude+","
					+ ""+depth+","+magnitude+","+region);
			out.flush();
			//每读取完一行，刷新缓冲区
		}
		out.close();
	}
}
