package org.foxminded.yLobanov.anagram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

private class AnagramMakerTest {

    public AnagramMaker maker = new AnagramMaker();

    @Test
    void anagramMakerShouldThrowIllegalArgumentExceptionWhenLineEqualsNullTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            maker.makeAnagram(null);
        });

        String expectedMessage = "sentence is null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void anagramMakerShouldThrowIllegalArgumentExceptionWhenLineContainsTabsAndSpacesTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            maker.makeAnagram(" 	");
        });

        String expectedMessage = "sentence contains only spaces and/or tabs";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void anagramMakerShouldThrowIllegalArgumentExceptionWhenLineContainsSingleSpace() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            maker.makeAnagram(" ");
        });

        String expectedMessage = "sentence contains only spaces and/or tabs";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void anagramMakerShouldThrowIllegalArgumentExceptionWhenLineIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            maker.makeAnagram("");
        });

        String expectedMessage = "sentence is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfSingleCharacterC() {
        assertEquals("c", maker.makeAnagram("c"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfDoubleCharacter() {
        assertEquals("cd", maker.makeAnagram("dc"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfMultipleSameCharacters() {
        assertEquals("cccc", maker.makeAnagram("cccc"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfMultipleSameCharacterDifferentCase() {
        assertEquals("cCcC", maker.makeAnagram("CcCc"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfSingleWordOnlyLetter() {
        assertEquals("catdog", maker.makeAnagram("godtac"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfMultipleWordOnlyLetter() {
        assertEquals("ekaw em pu nehw rebmetpes sdne", maker.makeAnagram("wake me up when september ends"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfOnlySymbolWord() {
        assertEquals("12345", maker.makeAnagram("12345"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfSymbolLetterSingleWord() {
        assertEquals("3c4b", maker.makeAnagram("3b4c"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfOnlySymbolMultipleWord() {
        assertEquals("12345 678 90", maker.makeAnagram("12345 678 90"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfMultipleWord() {
        assertEquals("cat dog 12 3c4b", maker.makeAnagram("tac god 12 3b4c"));
    }

    @Test
    void anagramMakerShouldReturnCorrectIfMultipleWordSymbolsAtTheEnd() {
        assertEquals("cat dog 12 3c4b eab12345", maker.makeAnagram("tac god 12 3b4c bae12345"));
    }
}
