package org.core.practice.building_blocks.creating_objects;

@SuppressWarnings("ALL")
public class Chick {
    private String name = "Fluffy";
    {System.out.println("Setting field");}

    public Chick() {
        name = "Tiny";
        System.out.println("Setting constructor");
    }

    // Setting field
    // Setting constructor
    // Tiny
    public static void main(String[] args) {
        Chick chick = new Chick();
        System.out.println(chick.name);
    }
}
