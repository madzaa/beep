package com.beep;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input = scanner.nextInt();
            if (isInBoundaries(input)) {
                for (int i = 0; i < input; i++) {
                    Thread.sleep(1000);
                    System.out.println(beep());
                }
            } else {
                System.out.println("Input should be in the range of 1-9");
            }
        }
    }
    public static String beep() {
        byte[] byteArray = new byte[]{ 0x07,0x42, 0x45, 0x45, 0x50};
        return new String(byteArray, StandardCharsets.UTF_8);
    }


    public static boolean isInBoundaries(int input) {
        boolean lowerBoundary = Character.digit(0x31, 16) <= input;
        boolean upperBoundary = Character.digit(0x39, 16) >= input;
        return upperBoundary && lowerBoundary;
    }

}