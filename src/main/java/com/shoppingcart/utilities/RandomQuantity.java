package com.shoppingcart.utilities;

import java.util.Arrays;
import java.util.Random;

public class RandomQuantity {

    public static String setRandomQuantity(){

        Random r = new Random();
        int low = 2;
        int high = 5;
        int result = r.nextInt(high-low) + low;

        String randomNumber = Integer.toString(result);
        System.out.println("-------------------------------------------");
        System.out.println("++Metodo para setear cantidad aleatoria++");
        System.out.println("La cantidad asignada ha sido: " + randomNumber);
        System.out.println("-------------------------------------------");
        return randomNumber;
    }

    public static String storeRandomNumbers(String[] args)
    {
        int[] numbers = new int[10];
        //Generates 10 Random Numbers in the range 1 -20
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(setRandomQuantity());
        }//end for loop
        System.out.println("Numbers Generated: " + Arrays.toString(numbers));
        return String.valueOf(numbers);
    }
}
