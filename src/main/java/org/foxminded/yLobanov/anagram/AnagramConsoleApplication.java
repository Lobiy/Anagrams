package org.foxminded.yLobanov.anagram;

import java.util.Scanner;

public class AnagramConsoleApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(AnagramMaker.makeAnagram(line));
    }
}
