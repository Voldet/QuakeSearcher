package service;
/**
 * Author Vold
 */
public class StringSingleFilterService implements SingleValueFilter {


    @Override
    public String databaseSingleFilter() {
        return null;
    }

    /**
     * @param region
     * @return region
     */
    public String databaseSingleFilter(String region) {
        return region;
    }
}