package org.foxminded.yLobanov.anagram;

import java.util.Scanner;

public class AnagramConsoleApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        AnagramMaker maker = new AnagramMaker();
        System.out.println(maker.makeAnagram(line));
    }
}
