package org.core.practice.building_blocks.creating_objects;

public class Egg {

    public Egg() {
        number = 5;
    }

    // 5
    // according to the order of initialization rules
    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number);

    }

    private int number = 3;
    {number = 4;}
}
