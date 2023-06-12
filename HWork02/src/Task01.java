import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Task01 {

    public static String completeDBRequest(String base, String fname) {

        StringBuilder res = new StringBuilder(base);

        JSONObject select = JsonStringFromFile(fname);

        boolean ifFirst = true;//first field to check - no need for AND/OR
        for (Object keyObj : select.keySet()) {
            String value = (String)select.get(keyObj);
            if (!value.contains("null")) {
                if (!ifFirst) {
                    res.append(" AND");
                } else
                    ifFirst = false;
                res.append(" " + (String) keyObj + " = '" + value + "'");
            }
        }

        return "\"" + res.toString() + "\"";
    }

    private static JSONObject JsonStringFromFile(String fname) {

        try {

            Object obj = new JSONParser().parse(new FileReader(fname));
            JSONObject slc = (JSONObject) obj;

            return slc;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
