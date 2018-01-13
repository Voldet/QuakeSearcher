package service;

import java.util.HashMap;

/**
 * Author Vold
 */
public class SqlFixerImpl implements SqlFixer {
    /**
     * To fix the earthquake which are what we need
     * It apply the fuzzy query
     * @see service.SqlFixer#fix(java.lang.String, java.util.HashMap)
     */
    @Override
    public String fix(String originSql,HashMap<String,Object> filterTest){
        StringBuffer conditions = new StringBuffer(" where ");
        for (String key:filterTest.keySet()){
            if (key.contains("From")){
                conditions.append("UTC_date" + ">=\"" + filterTest.get(key) + "\" and ");
            }else if (key.contains("Max")){
                conditions.append(key.replaceAll("Max","") + "<=" + filterTest.get(key) + " and ");
            }else if (key.contains("To")){
                conditions.append("UTC_date" + "<=\"" + filterTest.get(key) + "\" and ");
            }else if (key.contains("region")){
            	conditions.append(key+" like '%" + filterTest.get(key) + "%' and ");
            }
        }
        return originSql + conditions.delete(conditions.length()-4,conditions.length()-1) + ";";
    }
    /**
     * Except the region to list all the quake
     * @param originSql
     * @param filterTest
     * @return
     */
    public String fixAll(String originSql,HashMap<String,Object> filterTest){
        StringBuffer conditions = new StringBuffer(" where ");
        for (String key:filterTest.keySet()){
            if (key.contains("From")){
                conditions.append("UTC_date" + ">=\"" + filterTest.get(key) + "\" and ");
            }else if (key.contains("Max")){
                conditions.append(key.replaceAll("Max","") + "<=" + filterTest.get(key) + " and ");
            }else if (key.contains("To")){
                conditions.append("UTC_date" + "<=\"" + filterTest.get(key) + "\" and ");
            }
        }
        return originSql + conditions.delete(conditions.length()-4,conditions.length()-1) + ";";
    }
}