package homework5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhone("Alex", "+79819841752");
        phoneBook.addPhone("Alex", "+79817325313");
        phoneBook.addPhone("Bob", "+79212320990");
        phoneBook.addPhone("Ann", "+79030934002");
        System.out.println("Finding phone number by name:");
        System.out.println(phoneBook.getPhone("Bob"));
        System.out.println("Showing all phone numbers:");
        phoneBook.showAll();
    }
}
class PhoneBook{
    Map<String, ArrayList<String>> data;

    public PhoneBook() {
        data = new HashMap<>();
    }
    public void addPhone(String name, String number){
        if (data.containsKey(name))
            data.get(name).add(number);
        else
            data.put(name, new ArrayList<>(List.of(number)));
    }
    public ArrayList<String> getPhone(String name){
        return data.get(name);
    }
    public void showAll(){
        for(var item: data.entrySet()){
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }
}
