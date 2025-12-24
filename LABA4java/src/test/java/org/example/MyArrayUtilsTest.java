import org.testng.annotations.*;
import static org.testng.Assert.*;

public class MyArrayUtilsTest {

    private MyArrayUtils utils;

    @BeforeClass
    public void setUp() {
        utils = new MyArrayUtils();
        System.out.println("Инициализация MyArrayUtils");
    }

    @Test(groups = {"positive", "findMax"})
    public void testFindMaxPositive() {
        int[] arr = {1, 5, 3, 9, 2};
        assertEquals(utils.findMax(arr), 9);
    }

    @Test(groups = {"positive", "findMax"})
    public void testFindMaxWithNegatives() {
        int[] arr = {-10, -5, -1, -20};
        assertEquals(utils.findMax(arr), -1);
    }

    @Test(groups = {"positive", "sum"})
    public void testSum() {
        int[] arr = {1, 2, 3};
        assertEquals(utils.sum(arr), 6);
    }

    @Test(groups = {"edge_case", "sum"})
    public void testSumEmpty() {
        int[] arr = {};
        assertEquals(utils.sum(arr), 0);
    }

    @Test(groups = {"positive", "sort"})
    public void testIsSortedTrue() {
        int[] arr = {1, 2, 3, 5};
        assertTrue(utils.isSorted(arr));
    }

    @Test(groups = {"negative", "sort"})
    public void testIsSortedFalse() {
        int[] arr = {1, 3, 2, 5};
        assertFalse(utils.isSorted(arr));
    }

    @Test(groups = {"exception"}, expectedExceptions = IllegalArgumentException.class)
    public void testFindMaxException() {
        int[] arr = {};
        utils.findMax(arr);
    }

    @Test(groups = {"exception"}, expectedExceptions = ArithmeticException.class)
    public void testGetAverageException() {
        int[] arr = {};
        utils.getAverage(arr);
    }

    @DataProvider(name = "reverseDataProvider")
    public Object[][] provideDataForReverse() {
        return new Object[][] {
                { new int[]{1, 2, 3}, new int[]{3, 2, 1} },
                { new int[]{5}, new int[]{5} },
                { new int[]{}, new int[]{} },
                { new int[]{-1, 0, 1}, new int[]{1, 0, -1} }
        };
    }

    @Test(groups = {"dataprovider"}, dataProvider = "reverseDataProvider")
    public void testReverse(int[] input, int[] expected) {
        assertEquals(utils.reverse(input), expected);
    }
}