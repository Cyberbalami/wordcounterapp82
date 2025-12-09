package com.example.wordcounterapp82;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextMetricCounterTest {

    // ---------- Sentences ----------
    @Test
    public void testSentenceCountBasic() {
        String text = "Hello world. This is a test!";
        assertEquals(2, TextMetricCounter.countSentences(text));
    }

    @Test
    public void testSentenceCountMultiplePunctuation() {
        String text = "Hi! Are you okay? Yes.";
        assertEquals(3, TextMetricCounter.countSentences(text));
    }

    @Test
    public void testSentenceCountNoPunctuation() {
        String text = "This is a sentence without punctuation";
        assertEquals(1, TextMetricCounter.countSentences(text));
    }

    @Test
    public void testSentenceCountEmpty() {
        assertEquals(0, TextMetricCounter.countSentences(""));
    }

    // ---------- Words ----------
    @Test
    public void testWordCountBasic() {
        String text = "Hello world from Java";
        assertEquals(4, TextMetricCounter.countWords(text));
    }

    @Test
    public void testWordCountMultipleSpaces() {
        String text = "Hello   world   test";
        assertEquals(3, TextMetricCounter.countWords(text));
    }

    @Test
    public void testWordCountWithPunctuation() {
        String text = "Hello, world. Test sentence.";
        assertEquals(4, TextMetricCounter.countWords(text)); // UPDATED EXPECTED VALUE
    }

    @Test
    public void testWordCountEmpty() {
        assertEquals(0, TextMetricCounter.countWords(""));
    }

    // ---------- Characters ----------
    @Test
    public void testCharacterCount() {
        String text = "ABC";
        assertEquals(3, TextMetricCounter.countCharacters(text));
    }

    @Test
    public void testCharacterCountNull() {
        assertEquals(0, TextMetricCounter.countCharacters(null));
    }

    // ---------- Numbers ----------
    @Test
    public void testNumberCountBasic() {
        String text = "A1B2C3";
        assertEquals(3, TextMetricCounter.countNumbers(text));
    }

    @Test
    public void testNumberCountNoDigits() {
        String text = "Hello world";
        assertEquals(0, TextMetricCounter.countNumbers(text));
    }

    @Test
    public void testNumberCountMixed() {
        String text = "Room 305, floor 4";
        assertEquals(4, TextMetricCounter.countNumbers(text));
    }
}
