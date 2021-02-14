package sbu.cs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseLecture6Test {

    static ExerciseLecture6 el6;

    @BeforeAll
    static void setUp() {
        el6 = new ExerciseLecture6();
    }


    @Test
    void calculateEvenSumOdd() {
        assertEquals(el6.calculateEvenSum(new int[]{1, -2, 3, 4, 5}), 9);
    }

    @Test
    void calculateEvenSumEven() {
        assertEquals(el6.calculateEvenSum(new int[]{4, 3, -2, -2}), 2);
    }

    @Test
    void calculateEvenSumBig() {
        assertEquals(el6.calculateEvenSum(
                new int[]{Integer.MAX_VALUE, 3, Integer.MAX_VALUE, -2}),
                (long) Integer.MAX_VALUE * 2);
    }

    @Test
    void reverseArray() {
        assertArrayEquals(
                el6.reverseArray(new int[]{1, 2, 3, 4}),
                new int[]{4, 3, 2, 1}
                );
    }

    @Test
    void matrixProduct() {
        double[][] m1 = new double[1][2];
        double[][] m2 = new double[2][1];
        m1[0][0] = 1.5;
        m1[0][1] = 2;
        m2[0][0] = -1;
        m2[1][0] = 1.5;
        double[][] output = el6.matrixProduct(m1, m2);
        assertEquals(output.length, 1);
        assertEquals(output[0][0], 1.5);
    }

    @Test
    void matrixProductWrong() {
        double[][] m1 = new double[1][2];
        double[][] m2 = new double[1][2];
        assertThrows(Exception.class, () -> el6.matrixProduct(m1, m2));
    }

    @Test
    void arrayToList() {
        String[][] sample = new String[][]{
                {"ali", "ali", "saeed"},
                {"morteza", "sadegh", "ahmad"}
        };
        List<List<String>> output = el6.arrayToList(sample);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(output.get(i).get(j), sample[i][j]);
            }
        }
    }

    @Test
    void primeFactorsOne() {
        List<Integer> output = el6.primeFactors(1);
        assertEquals(output.size(), 0);
    }

    @Test
    void primeFactorsPrime() {
        List<Integer> output = el6.primeFactors(13);
        assertEquals(output.size(), 1);
        assertEquals(output.get(0), 13);
    }

    @Test
    void primeFactorsSample() {
        List<Integer> output = el6.primeFactors(120);
        assertEquals(output.size(), 3);
        assertEquals(output.get(0), 2);
        assertEquals(output.get(1), 3);
        assertEquals(output.get(2), 5);
    }

    @Test
    void extractWord() {
        String line = "hi! how ,are you?";
        List<String> output = el6.extractWord(line);
        assertEquals(output.size(), 4);
        assertEquals(output.get(0), "hi");
        assertEquals(output.get(1), "how");
        assertEquals(output.get(2), "are");
        assertEquals(output.get(3), "you");
    }
}