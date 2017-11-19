package cyrilpillai.supernatives.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import io.objectbox.converter.PropertyConverter;

/**
 * Created by cyrilpillai on 12-11-2017.
 */

public class DatabaseHelper {

    //TODO Try to eliminate the creation of a new Gson instance
    public static class StringListConverter implements PropertyConverter<List<String>, String> {
        @Override
        public List<String> convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            return new Gson().fromJson(databaseValue, new TypeToken<List<String>>() {
            }.getType());
        }

        @Override
        public String convertToDatabaseValue(List<String> entityProperty) {
            return entityProperty == null ? null : new Gson().toJson(entityProperty);
        }
    }
}
