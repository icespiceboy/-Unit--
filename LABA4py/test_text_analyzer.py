import pytest
from text_analyzer import TextAnalyzer

class TestTextAnalyzer:
    analyzer = TextAnalyzer()

    # 1. Параметризованный тест (аналог DataProvider)
    @pytest.mark.parametrize("word, expected", [
        ("madam", True),
        ("java", False),
        ("шалаш", True),
        ("", True)
    ])
    @pytest.mark.logic
    def test_is_palindrome(self, word, expected):
        assert self.analyzer.is_palindrome(word) == expected

    # 2-3. Тесты исключений
    @pytest.mark.exceptions
    def test_count_words_exception(self):
        with pytest.raises(ValueError):
            self.analyzer.count_words(None)

    @pytest.mark.exceptions
    def test_to_slug_exception(self):
        with pytest.raises(ValueError):
            self.analyzer.to_slug(None)

    # 4-8. Обычные тесты с группами
    @pytest.mark.metrics
    def test_count_words_normal(self):
        assert self.analyzer.count_words("Hello World Python") == 3

    @pytest.mark.metrics
    def test_count_vowels(self):
        assert self.analyzer.count_vowels("Apple") == 2

    @pytest.mark.formatting
    def test_to_slug(self):
        assert self.analyzer.to_slug("My New Post") == "my-new-post"

    @pytest.mark.logic
    def test_check_length_success(self):
        assert self.analyzer.check_length("Test", 2, 5) is True

    @pytest.mark.logic
    def test_check_length_fail(self):
        assert self.analyzer.check_length("Too long string", 1, 5) is False

    @pytest.mark.metrics
    def test_empty_string_words(self):
        assert self.analyzer.count_words("   ") == 0