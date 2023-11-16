package com.dev.bank.util;

import java.util.Random;

public class CreditCardGenerator {

    public static String generateCardNumber() {
        Random random = new Random();

        StringBuilder cardNumber = new StringBuilder();
        cardNumber.append("4");

        for (int i = 0; i < 15; i++) {
            cardNumber.append(random.nextInt(10));
        }

        cardNumber.append(calculateLuhn(cardNumber.toString()));

        return cardNumber.toString();
    }

    private static int calculateLuhn(String number) {
        int s = 0;
        boolean alt = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));

            if (alt) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            s += digit;
            alt = !alt;
        }

        return (10 - (s % 10)) % 10;
    }
}
