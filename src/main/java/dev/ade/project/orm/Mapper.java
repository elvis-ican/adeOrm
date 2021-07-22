package dev.ade.project.orm;

import dev.ade.project.exception.ArgumentFormatException;

import java.util.List;

public interface Mapper {
    Object get(String pkName, Object pkValue) throws ArgumentFormatException;
//    int add(String tableName, List<Field> fields, String pkName, Object pkValue) throws ArgumentFormatException;
    boolean add(String tableName, List<FieldPair> fieldPairs, int idCriteria) throws ArgumentFormatException;
//    int update(String tableName, List<Field> fields, String pkName, Object pkValue) throws ArgumentFormatException;
//    int delete(String tableName, String pkName, Object pkValue) throws ArgumentFormatException;
}
