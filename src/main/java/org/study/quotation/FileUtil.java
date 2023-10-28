package org.study.quotation;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtil {

    final String PATH = "C:\\Users\\ppusd\\Desktop\\JDG\\Study\\likeLion\\phraseApp\\java-phraseApp\\src\\main\\java\\org\\example\\data.json";
    JSONParser jsonParser = new JSONParser();

    void fileSave(ArrayList<Quotation> quotationList) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        for (Quotation quotation : quotationList) {
            jsonObject.put("id", quotation.getId());
            jsonObject.put("author", quotation.getAuthor());
            jsonObject.put("content", quotation.getPhrase());
            jsonArray.add(jsonObject);
        }
        try {
            FileWriter file = new FileWriter(PATH);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<Quotation> fileLoad() {
        ArrayList<Quotation> quotations = new ArrayList<>();

        try {
            FileReader reader = new FileReader(PATH);

            Object obj = jsonParser.parse(reader);

            if (obj instanceof JSONArray) {
                // JSON 배열로 처리
                JSONArray jsonArray = (JSONArray) obj;
                for (Object item : jsonArray) {
                    JSONObject object = (JSONObject) item;
                    quotations.add(new Quotation((Long) object.get("id"), (String) object.get("content"), (String) object.get("author")));
                }
            } else if (obj instanceof JSONObject) {
                // JSON 객체로 처리
                JSONObject object = (JSONObject) obj;
                if(!((JSONObject) obj).isEmpty()){
                    quotations.add(new Quotation((Long) object.get("id"), (String) object.get("content"), (String) object.get("author")));
                }
            } else {
                System.err.println("허용 되지 않는 JSON 구조 입니다.");
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return quotations;
    }
}
