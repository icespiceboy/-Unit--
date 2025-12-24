package org.example;

public class TextAnalyzer {

    public int countWords(String text) {
        if (text == null) throw new IllegalArgumentException("Text cannot be null");
        if (text.trim().isEmpty()) return 0;
        return text.trim().split("\\s+").length;
    }

    public boolean isPalindrome(String word) {
        if (word == null) return false;
        String clean = word.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    public int countVowels(String text) {
        if (text == null) throw new IllegalArgumentException("Text cannot be null");
        return (int) text.toLowerCase().chars()
                .filter(c -> "aeiouyаеёиоуыэюя".indexOf(c) != -1)
                .count();
    }

    public String surgeryToSlug(String text) {
        if (text == null) throw new IllegalArgumentException("Text cannot be null");
        return text.toLowerCase().trim().replaceAll("\\s+", "-");
    }

    public boolean checkLength(String text, int min, int max) {
        if (text == null) return false;
        return text.length() >= min && text.length() <= max;
    }
}