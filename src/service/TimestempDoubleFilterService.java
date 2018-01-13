package service;

import java.sql.Timestamp;
import java.util.ArrayList;
/**
 * Author Vold
 */
public class TimestempDoubleFilterService implements DoubleValuesFilter {

    @Override
    public ArrayList<String> databaseDoubleFilter() {
        return null;
    }

    /**
     * To get date from dataFrom to dataTo
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public ArrayList<String> databaseDoubleFilter(Timestamp dateFrom, Timestamp dateTo) {
        ArrayList<String> filter = new ArrayList<String>();
        filter.add(dateFrom.toString());
        filter.add(dateTo.toString());
        return filter;
    }
}