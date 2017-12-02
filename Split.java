package project;

import java.util.ArrayList;
import java.util.Iterator;

public class Split extends father_list{
	public static void splitRes(ArrayList<String> allQuake){
		//allQuake是一个包含所有地震数据的ArrayList
		QuakeInfo saveQuake[] = new QuakeInfo[allQuake.size()];
		//用于储存地震数据的Node
		for(int i=0; i < allQuake.size(); i++){
			String splitString[] =allQuake.get(i).split(",");
			//读取的每一行用逗号一一分隔开，暂时储存到splitString数组中，接着填写入saveQuake中
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
		for(int i=0; i < saveQuake.length; i++){
			quake.add(saveQuake[i]);
		}
	}
}
