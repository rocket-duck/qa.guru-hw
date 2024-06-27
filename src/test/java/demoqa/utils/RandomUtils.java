package demoqa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomUtils {
    public static String[] getRandomDate() {
        Random random = new Random();
        int minDate = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDate = (int) LocalDate.of(2020, 12, 31).toEpochDay();
        long randomDay = minDate + random.nextInt(maxDate - minDate);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return randomDate.format(DateTimeFormatter.ofPattern("d/MM/yyyy")).split("/");
    }

    public static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }
}
