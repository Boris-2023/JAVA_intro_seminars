
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import java.io.FileReader;

public class Task03 {
    public static String[] printJsonMarks(String fname, boolean ifPrintOut) {

        JSONArray marksData = JsonArrayFromFile(fname);
        String[] res = new String[marksData.size()];

        for (int i = 0; i < marksData.size(); i++) {
            res[i] = stringMark((JSONObject) marksData.get(i));
            if (ifPrintOut)
                System.out.println(res[i]);
        }

        return res;
    }

    private static JSONArray JsonArrayFromFile(String fname) {

        try {

            Object obj = new JSONParser().parse(new FileReader(fname));
            JSONArray arr = (JSONArray) obj;

            return arr;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static String stringMark(JSONObject mark) {
        String[] values = new String[3];
        int i = 0;

        for (Object key : mark.keySet()) {
            switch ((String) key) {
                case "фамилия":
                    i = 0;
                    break;
                case "оценка":
                    i = 1;
                    break;
                case "предмет":
                    i = 2;
                    break;
                default:
                    System.out.println("Unlisted key in JSON! Task03.stringMark().");
            }
            values[i] = (String) mark.get(key);
        }

        StringBuilder res = new StringBuilder("Студент ");
        res.append(values[0]);
        res.append(" получил ");
        res.append(values[1]);
        res.append(" по предмету ");
        res.append(values[2]);
        res.append(".");

        return res.toString();
    }

}
