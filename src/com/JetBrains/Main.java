package com.JetBrains;

import java.util.Scanner;

public class Main {
    public static boolean matches(String text, String regex) {
        MyMatcher.setTimout(10);
        return MyMatcher.matches(text, regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        String regex = scanner.next();

        System.out.println(Main.matches(text, regex));

    }
}
