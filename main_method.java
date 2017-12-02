package project;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main_method extends father_list {
	public void search(String toFind,ArrayList<QuakeInfo> quake){
		//查询的方法
		List results = new ArrayList();
		Pattern pattern = Pattern.compile(toFind);
		Matcher matcher = null;
		for(int i = 0;i<quake.size(); i++){
			matcher = pattern.matcher(quake.get(i).getId());
			//按ID 进行模糊查询
			if(matcher.find()){
				results.add(quake.get(i));
			}
			matcher = pattern.matcher(quake.get(i).getUTC_date());
			//按UTC_date 进行模糊查询
			if(matcher.find()){
				results.add(quake.get(i));
			}
			matcher = pattern.matcher(quake.get(i).getRegion());
			//按region 进行模糊查询
			if(matcher.find()){
				results.add(quake.get(i));
			}
		}
	}
	
	public void refresh(){
		
	}
	public void list_all_quake(){

	}
}
