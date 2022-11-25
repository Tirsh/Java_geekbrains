package homework2;


import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        String jsonStr = String.format("{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Smith\",\n" +
                "  \"isAlive\": true,\n" +
                "  \"age\": 27,\n" +
                "  \"address\": {\n" +
                "    \"streetAddress\": \"21 2nd Street\",\n" +
                "    \"city\": \"New York\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"postalCode\": \"10021-3100\"\n" +
                "  },\n" +
                "  \"phoneNumbers\": [\n" +
                "    {\n" +
                "      \"type\": \"home\",\n" +
                "      \"number\": \"212 555-1234\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"office\",\n" +
                "      \"number\": \"646 555-4567\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"children\": [\n" +
                "      \"Catherine\",\n" +
                "      \"Thomas\",\n" +
                "      \"Trevor\"\n" +
                "  ],\n" +
                "  \"spouse\": null\n" +
                "}");
        System.out.println(jsonStr);
        //MyJson myJson = new MyJson(jsonStr);

    }




}

class MyJson{
    private Map<String,String[]> jsonMap;

    public MyJson(String jsonStr) {
        this.jsonMap = jsonMap;
        jsonStrToMap(jsonStr);
    }
    private void jsonStrToMap(String str){
        String json = str.replaceAll("\\s+", "");
        //System.out.println(json.replaceAll("\"\\w+\":\\{[\":\\-,\\w]+\\}", ""));
        System.out.println(json.replaceAll("\"\\w+\":\"[\\w-]+\"|\"\\w+\":\\w+", "'':''"));
    }

    private
}

//{
//        "firstName": "John",
//        "lastName": "Smith",
//        "isAlive": true,
//        "age": 27,
//        "address": {
//        "streetAddress": "21 2nd Street",
//        "city": "New York",
//        "state": "NY",
//        "postalCode": "10021-3100"
//        },
//        "phoneNumbers": [
//        {
//        "type": "home",
//        "number": "212 555-1234"
//        },
//        {
//        "type": "office",
//        "number": "646 555-4567"
//        }
//        ],
//        "children": [
//        "Catherine",
//        "Thomas",
//        "Trevor"
//        ],
//        "spouse": null
//        }