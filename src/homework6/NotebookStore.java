package homework6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NotebookStore {
    Set<Notebook> notebooksOnStock;

    public NotebookStore() {
        notebooksOnStock = new HashSet<>();
    }

    public NotebookStore(Notebook[] notebooks) {
        notebooksOnStock = new HashSet<>(Arrays.asList(notebooks));
    }
    public void addNotebook(Notebook notebook){
        notebooksOnStock.add(notebook);
    }
    public Set<Notebook> findByOptions(Notebook protoNote){

        return notebooksOnStock;
    }
    private Notebook createRequest(){
        int ram = 0;
        int hdVolume = 0;
        String os = "";
        String color = "";
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while(option != 5) {
            System.out.println("   “Введите цифру, соответствующую необходимому критерию:  \n" +
                    "   1 - ОЗУ  \n" +
                    "   2 - Объем ЖД  \n" +
                    "   3 - Операционная система  \n" +
                    "   4 - Цвет  \n" +
                    "   5 - Поиск");
            if (scanner.hasNext())
                option = scanner.nextInt();
        }

        return new Notebook("","", null, 0, 0, "", "");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Notebook notebook:notebooksOnStock) {
            stringBuilder.append(notebook);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
