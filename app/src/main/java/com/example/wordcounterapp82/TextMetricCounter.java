package com.example.wordcounterapp82;

/**
 * Utility class for counting text metrics: sentences, words,
 * characters, and numbers.
 */
public class TextMetricCounter {

    /**
     * Improved sentence counting method.
     * Handles abbreviations, newlines, empty splits.
     */
    public static int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        // Prevent splitting on abbreviations like "Dr.", "Mr.", etc.
        String cleaned = text.replaceAll("\\b(Mr|Mrs|Ms|Dr|Prof|Sr|Jr)\\.", "$1");

        // Split on punctuation that ends sentences: . ! ?
        String[] parts = cleaned.split("[.!?]+(?=\\s|$)");

        int count = 0;
        for (String part : parts) {
            if (part.trim().length() > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts words separated by whitespace or punctuation.
     */
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] words = text.split("[\\s,.]+");
        int wordCount = 0;

        for (String word : words) {
            if (!word.trim().isEmpty()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    /**
     * Counts all characters including spaces.
     */
    public static int countCharacters(String text) {
        return text != null ? text.length() : 0;
    }

    /**
     * Counts individual digits 0–9.
     */
    public static int countNumbers(String text) {
        if (text == null) {
            return 0;
        }

        int digitCount = 0;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        return digitCount;
    }
}
