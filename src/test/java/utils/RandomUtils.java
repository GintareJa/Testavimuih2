package utils;

import java.util.Random;

public class RandomUtils {

    public static String generateRandomUsername() {
        return "user" + new Random().nextInt(1000);
    }

    public static String generateRandomPassword() {
        return "pass" + new Random().nextInt(1000);
    }

}
