package org.core.practice.building_blocks.main_method;

/**
 * Accessing larger amount of parameters, than was passed to
 * application, results in ArrayIndexOutOfBoundsException
 */
public class PassingParametersToMain {

    // java PassingParametersToMain "San Diego"
    // ArrayIndexOutOfBoundsException
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
