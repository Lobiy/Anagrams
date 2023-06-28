package org.foxminded.yLobanov.anagram;

import java.util.Arrays;

public class AnagramMaker {

    private static final String SPACE_DELIMITER = " ";

    public String makeAnagram(String sentence) {
        validateSentence(sentence);

        String[] words = sentence.split(SPACE_DELIMITER);
        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reversedWord(words[i]);
        }
        return concat(reversedWords);
    }

    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        }

        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("sentence is empty");
        }

        if (sentence.matches("\\s*")) {
            throw new IllegalArgumentException("sentence contains only spaces and/or tabs");
        }

    }

    private String reversedWord(String word) {
        char[] symbols = new char[word.length()];
        Arrays.fill(symbols, ' ');
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            if (!Character.isLetter(symbol)) {
                symbols[i] = symbol;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            if (Character.isLetter(symbol)) {
                int j = word.length() - 1;
                while (j > -1 && symbols[j] != ' ') {
                    j--;
                }
                symbols[j] = symbol;
            }
        }
        return new String(symbols);
    }

    private String concat(String[] words) {
        return String.join(SPACE_DELIMITER, words).trim();
    }

}
