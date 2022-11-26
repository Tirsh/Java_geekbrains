package homework2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String fileName = "./src/homework2/data.json";
        String data = null;
        try {
            data = getStringFromFile(fileName);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(String.format("%s not found", fileName));
        }
        List<Map<String, String>> elementsList;
        elementsList = mySimpleJsonParser(data);
        StringBuilder result = new StringBuilder();
        for (Map<String, String> element:elementsList) {
            result.append(jsonElementToText(element));
            result.append("\n");
        }
        System.out.println(result.toString());
    }

    public static String getStringFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String lineSep = System.getProperty("line.separator");
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append(lineSep);
        }
        return stringBuilder.toString();
    }
    public static List<Map<String, String>> mySimpleJsonParser(String str){
        String jsonStr = str.replaceAll("\\s", "");
        List<Map<String, String>> hashMapArr = new ArrayList<>();
        Pattern patternElement = Pattern.compile("\\{(\"[А-Яа-я\\w]+\":\"[А-Яа-я\\w]+\",?)+}");
        Pattern patternField = Pattern.compile("\"[А-Яа-я\\w]+\":[А-Яа-я\\w\"]+");
        Matcher matcherElement = patternElement.matcher(jsonStr);
        Matcher matcherField = null;
        while (matcherElement.find()){
            String element = jsonStr.substring(matcherElement.start(), matcherElement.end());
            matcherField = patternField.matcher(element);
            Map<String, String> elementMap = new HashMap<>();
            while (matcherField.find()){
                String[] field = element.substring(matcherField.start(), matcherField.end())
                        .replaceAll("\"", "")
                        .split(":");
                elementMap.put(field[0], field[1]);
            }
            hashMapArr.add(elementMap);
        }
        return hashMapArr;
    }
    public static String jsonElementToText(Map<String, String> element){
        return String.format("Студент %s получил %s по предмету %s", element.get("фамилия"), element.get("оценка"),element.get("предмет"));
    }

}
