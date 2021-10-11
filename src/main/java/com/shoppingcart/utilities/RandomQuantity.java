package com.shoppingcart.utilities;

import java.util.Random;

public class RandomQuantity {

    public static String setRandomQuantity(){

        Random r = new Random();
        int low = 2;
        int high = 5;
        int result = r.nextInt(high-low) + low;

        String randomNumber = Integer.toString(result);
        System.out.println("++METODO ASIGNAR CANTIDAD ALEATORIA++");
        System.out.println("LA CANTIDAD ASIGNADA AL PRODUCTO HA SIDO: " + randomNumber);
        return randomNumber;
    }
}
