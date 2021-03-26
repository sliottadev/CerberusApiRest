package com.cerberus.helpers;

import com.cerberus.enums.LoggerType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class GenericMapper {

    private static ObjectMapper mapper = new ObjectMapper();
    private static Logger logger = new Logger();

    public static <T> String serialize(T object) {
        String data = null;
        try {
            data = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.Write(LoggerType.LOG_ERROR, "Error en el proceso de serializacion. Detalles: " + e.getMessage());
        }
        return data;
    }

    public static <T> T deserialize(String json, Class<T> type) {
        T data = null;
        try {
            data = mapper.readValue(json, type);
        } catch (IOException e) {
            logger.Write(LoggerType.LOG_ERROR, "Error en el proceso de des-serializacion. Detalles: " + e.getMessage());
        }
        return data;
    }
}
