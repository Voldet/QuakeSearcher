package project;

import java.util.ArrayList;
import java.util.Iterator;

public class Split {
	public static void splitRes(ArrayList<String> a){
		//a是一个包含所有地震数据的ArrayList
		QuakeInfo saveQuake[] = new QuakeInfo[a.size()];
		//用于储存地震数据的Node
		for(int i=0; i < a.size(); i++){
			String splitString[] =a.get(i).split(",");
			for(int j = 0; j < splitString.length; j++){
				saveQuake[i].setId(splitString[j]);
				saveQuake[i].setUTC_date(splitString[j]);
				saveQuake[i].setLatitude(splitString[j]);
				saveQuake[i].setLongitude(splitString[j]);
				saveQuake[i].setDepth(splitString[j]);
				saveQuake[i].setMagnitude(splitString[j]);
				saveQuake[i].setRegion(splitString[j]);
			}
		}
	}
}
