package org.example;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextAnalyzerTest {
    TextAnalyzer analyzer = new TextAnalyzer();

    @DataProvider(name = "palindromeData")
    public Object[][] palindromeData() {
        return new Object[][] {
                {"madam", true},
                {"java", false},
                {"шалаш", true},
                {"", true}
        };
    }

    @Test(dataProvider = "palindromeData", groups = {"logic"})
    public void testIsPalindrome(String word, boolean expected) {
        Assert.assertEquals(analyzer.isPalindrome(word), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"exceptions"})
    public void testCountWordsException() {
        analyzer.countWords(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"exceptions"})
    public void testToSlugException() {
        analyzer.surgeryToSlug(null);
    }

    @Test(groups = {"metrics"})
    public void testCountWordsNormal() {
        Assert.assertEquals(analyzer.countWords("Hello World Java"), 3);
    }

    @Test(groups = {"metrics"})
    public void testCountVowels() {
        Assert.assertEquals(analyzer.countVowels("Apple"), 2);
    }

    @Test(groups = {"formatting"})
    public void testToSlug() {
        Assert.assertEquals(analyzer.surgeryToSlug("My New Post"), "my-new-post");
    }

    @Test(groups = {"logic"})
    public void testCheckLengthSuccess() {
        Assert.assertTrue(analyzer.checkLength("Test", 2, 5));
    }

    @Test(groups = {"logic"})
    public void testCheckLengthFail() {
        Assert.assertFalse(analyzer.checkLength("Too long string", 1, 5));
    }
}