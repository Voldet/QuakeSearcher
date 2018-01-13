package service;

import java.util.HashMap;

/**
 * Author Vold
 */
public interface SqlFixer {
    /**
     * @param originSql
     * @param filterTest
     * @return
     */
    String fix(String originSql, HashMap<String, Object> filterTest);
}