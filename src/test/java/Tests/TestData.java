package Tests;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestData {
    static Faker faker = new Faker();

    //Генерация рандомной строки
    public static String generateRandomName() {
        return faker.name().fullName();
    }

    //Генерация рандомного email
    public static String generateRandomEmail() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 10;
        StringBuilder username = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }

        String domain = "@example.com";

        return username.toString() + domain;
    }

    //Генерация рандомного password
    public static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder username = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }
        return username.toString();
    }
}