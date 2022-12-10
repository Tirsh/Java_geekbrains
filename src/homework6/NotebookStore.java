package homework6;

import homework6.options.*;
import java.util.*;

public class NotebookStore {
    Set<Notebook> notebooksOnStock;
    Map<Integer, Options> optionsMap;
    {
        optionsMap = new HashMap<>();
        optionsMap.put(1, new GetRam());
        optionsMap.put(2, new GetHddVolume());
        optionsMap.put(3, new GetOs());
        optionsMap.put(4, new GetColor());
    }

    public NotebookStore(Notebook[] notebooks) {
        notebooksOnStock = new HashSet<>(Arrays.asList(notebooks));
    }
    public void addNotebook(Notebook notebook){
        notebooksOnStock.add(notebook);
    }
    private Set<Notebook> findByOptions(Notebook protoNote){
        int ram = protoNote.getRam();
        int hddVolume = protoNote.getHdVolume();
        String os = protoNote.getOperationSystem();
        String color = protoNote.getColor();
        Set<Notebook> result = new HashSet<>();
        for (Notebook notebook:notebooksOnStock)
            if ((ram <= notebook.getRam()) && (hddVolume <= notebook.getHdVolume())
                    && ((os.equals("___")) || (os.equals(notebook.getOperationSystem())))
                    && ((color.equals("___")) || (color.equals(notebook.getColor()))))
                result.add(notebook);

        return result;
    }
    public Set<Notebook> createRequest(){
        int ram = 0;
        int hdVolume = 0;
        String os = "___";
        String color = "___";
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        while(option != 5) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.printf("""
                       Введите цифру, соответствующую необходимому критерию поиска, или "5" - для поиска: \s
                       1 - ОЗУ \s
                       2 - Объем ЖД \s
                       3 - Операционная система \s
                       4 - Цвет \s
                       5 - Поиск\s
                    Текущие критерии поиска: ОЗУ(Гб): %d; HDD(Гб): %d; OS: %s; Цвет: %s
                    """, ram, hdVolume, os, color);
            if (scanner.hasNext())
                option = scanner.nextInt();
            if (option == 1)
                ram = (int)optionsMap.get(option).getOption();
            else if (option == 2)
                hdVolume = (int)optionsMap.get(option).getOption();
            else  if (option == 3)
                os = (String)optionsMap.get(option).getOption();
            else if (option == 4)
                color = (String)optionsMap.get(option).getOption();

        }

        return findByOptions(new Notebook("","", null, ram, hdVolume, os, color));
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
