package com.app;

public class Main {

    public static void main(String[] args) {

        // PC composition
        Chassis chassis = new Chassis("220B","Dell", "120", new Dimensions(12, 1, 10));
        Monitor monitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard motherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC pc = new PC(chassis, monitor, motherboard);
        pc.powerUp();

        System.out.println("\n###########\n");

        // office room composition
        Desk desk = new Desk(30, 50, 20, "wood");
        Light light = new Light(40, 100, "warm");

        OfficeRoom officeRoom = new OfficeRoom(desk, light);
        officeRoom.hitLightSwitch();
        officeRoom.getDesk().openDrawer();
        officeRoom.hitLightSwitch();
    }
}
