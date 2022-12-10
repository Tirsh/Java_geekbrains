package homework6;

public class Notebook {
    private final int ram;
    private final int hdVolume;
    private final String operationSystem;
    private final String brand;
    private final String model;
    private final Cpu cpu;
    private final String color;

    public Notebook(String brand, String model, Cpu cpu, int ram, int hdVolume, String operationSystem, String color) {
        this.ram = ram;
        this.hdVolume = hdVolume;
        this.operationSystem = operationSystem;
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getHdVolume() {
        return hdVolume;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Cpu getCpu() {
        return cpu;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cpu=" + cpu +
                "ram=" + ram +
                ", hdVolume=" + hdVolume +
                ", operationSystem='" + operationSystem + '\'' +
                '}';
    }
}
enum Cpu{
    AMD , INTEL
}
