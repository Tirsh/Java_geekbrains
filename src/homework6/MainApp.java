package homework6;

import java.io.IOException;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) throws IOException {
        NotebookStore notebookStore = new NotebookStore(new Notebook[]{
                new Notebook("Acer", "Extensa EX215-22", Cpu.AMD, 16, 500, "Linux", "black"),
                new Notebook("Acer", "Aspire 3 A315-57G", Cpu.INTEL, 8, 1000, "Windows", "white"),
                new Notebook("Acer", "Swift 3 SF316-51", Cpu.INTEL, 8, 256, "Linux", "black"),
                new Notebook("Lenovo", "IdeaPad 3-14", Cpu.AMD, 4, 256, "Windows", "gray"),
                new Notebook("Lenovo", "IdeaPad 5 Pro 16", Cpu.INTEL, 16, 500, "Windows", "black"),
                new Notebook("Lenovo", "IdeaPad Gaming 3 15IHU6", Cpu.INTEL, 16, 1500, "Windows", "red"),
                new Notebook("HP", "14s-dq", Cpu.INTEL, 8, 500, "Windows", "white"),
                new Notebook("HP", "255 G8", Cpu.INTEL, 16, 1000, "Windows", "black"),
                new Notebook("HP", "Pavilion Gaming 17-cd", Cpu.AMD, 16, 1500, "Linux", "black")
        });
        notebookStore.addNotebook(new Notebook("Apple", "Macbook Air", Cpu.INTEL, 8, 256, "MacOs", "silver"));

        Set<Notebook> result = notebookStore.createRequest();
        printSet(result);

    }
    public static void printSet(Set<Notebook> data){
        for (Notebook notebook:data)
            System.out.println(notebook);
    }
}
