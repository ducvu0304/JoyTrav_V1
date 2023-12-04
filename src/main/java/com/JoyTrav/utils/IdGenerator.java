package com.JoyTrav.utils;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class IdGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final int CODE_LENGTH = 15;

    public  int generateID() {
        return (int) Math.floor(Math.random() * 999999999);
    }
    public String generateTourID() {
        return "TOUR"+generateCode();
    }
    public String generateHotelID() {return "HOTEL"+generateCode();}
    public String generateBookingID() {return "BOOKING"+generateCode();}

    public List<Integer> pageNumbers(int totalPage) {
        return  IntStream.rangeClosed(1,  totalPage)
                .boxed()
                .collect(Collectors.toList());
    }


    private static String generateUniqueCode() {
        Set<String> usedCodes = new HashSet<>();
        String code;

        do {
            code = generateCode();
        } while (!usedCodes.add(code));

        return code;
    }

    private static String generateCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        // Generate 3 random uppercase letters
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(LETTERS.length());
            code.append(LETTERS.charAt(randomIndex));
        }

        // Generate 4 random digits
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(NUMBERS.length());
            code.append(NUMBERS.charAt(randomIndex));
        }

        code.append("-");

        // Generate 6 random alphanumeric characters
        for (int i = 0; i < 6; i++) {
            String characters = LETTERS + NUMBERS;
            int randomIndex = random.nextInt(characters.length());
            code.append(characters.charAt(randomIndex));
        }

        return code.toString();
    }

}
