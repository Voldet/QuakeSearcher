package service;

import java.util.ArrayList;

/**
 * Author Vold
 */
public class FloatSingleFilter implements DoubleValuesFilter {

    @Override
    public ArrayList<String> databaseDoubleFilter() {
        return null;
    }

    /**
     * To get the quake which magnitude max level less than Max
     * @param earthquake
     * @param Max
     * @return
     */
    public ArrayList<String> databaseDoubleFilter( float Max) {
        ArrayList<String> filter = new ArrayList<String>();
        filter.add(String.valueOf(Max));
        return filter;
    }
}