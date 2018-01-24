package com.tsalapova.bicyclerental.mapper;

import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/24/2018
 */
public class POJOMapper<T> {
    public List<T> mapPojos(ResultSet resultSet, Class<T> mappingClass) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<T> objects = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        Field[] fields = mappingClass.getDeclaredFields();
        while (resultSet.next()) {
            T object = (T) mappingClass.newInstance();
            String name;
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                name = metaData.getColumnName(i);
                Object value = resultSet.getObject(i);
                for (Field field : fields) {
                    if (field.getName().equals(name) || field.getAnnotation(Column.class).name().equals(name)) {
                        BeanUtils.setProperty(object, field.getName(), value);
                    }
                }
            }
            objects.add(object);
        }
        return objects;
    }
}
