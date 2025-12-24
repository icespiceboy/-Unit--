import re

class TextAnalyzer:
    def count_words(self, text):
        if text is None:
            raise ValueError("Text cannot be None")
        if not text.strip():
            return 0
        return len(text.strip().split())

    def is_palindrome(self, word):
        if word is None:
            return False
        clean = re.sub(r'\s+', '', word).lower()
        return clean == clean[::-1]

    def count_vowels(self, text):
        if text is None:
            raise ValueError("Text cannot be None")
        vowels = "aeiouyаеёиоуыэюя"
        return sum(1 for char in text.lower() if char in vowels)

    def to_slug(self, text):
        if text is None:
            raise ValueError("Text cannot be None")
        return re.sub(r'\s+', '-', text.lower().strip())

    def check_length(self, text, min_len, max_len):
        if text is None:
            return False
        return min_len <= len(text) <= max_len