public class Main {
    public static void main(String[] args) {
        Appliance w1 = new WashingMachine("LG");
        w1.displayBrand();
        w1.turnOn();
        w1.operate();
        w1.turnOff();

        System.out.println();

        Appliance r1 = new Refrigerator("Panasonic");
        r1.displayBrand();
        r1.turnOn();
        r1.operate();
        r1.turnOff();
    }
}