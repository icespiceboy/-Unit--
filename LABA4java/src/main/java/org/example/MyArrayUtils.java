public class MyArrayUtils {

    public int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int sum(int[] arr) {
        if (arr == null) return 0;
        int total = 0;
        for (int j : arr) {
            total += j;
        }
        return total;
    }

    public int[] reverse(int[] arr) {
        if (arr == null) return null;
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) return true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public double getAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new ArithmeticException("Нельзя найти среднее для пустого массива");
        }
        return (double) sum(arr) / arr.length;
    }
}
