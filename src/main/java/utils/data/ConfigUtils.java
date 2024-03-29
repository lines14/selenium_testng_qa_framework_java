package utils.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Reporter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigUtils {

    public static HashMap<String, Object> getNewMapperHashStringObject(String path) {
        try {
            return new ObjectMapper()
                    .readValue(new File(path), new TypeReference<HashMap<String, Object>>() {
                    });
        } catch (Exception e) {
            Reporter.log("Failed to map a dictionary (key: string, value: object)", true);
            return null;
        }
    }

    public static Object getData(String path, String parameterName) {
        Map<String, Object> map = getNewMapperHashStringObject(path);
        for (Map.Entry<String, Object> p : map.entrySet()) {
            if (p.getKey().equals(parameterName)) {
                return p.getValue();
            }
        }
        return null;
    }
}
