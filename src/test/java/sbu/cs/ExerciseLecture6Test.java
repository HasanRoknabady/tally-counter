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
        assertEquals(9, el6.calculateEvenSum(new int[]{1, -2, 3, 4, 5}));
    }

    @Test
    void calculateEvenSumEven() {
        assertEquals(2, el6.calculateEvenSum(new int[]{4, 3, -2, -2}));
    }

    @Test
    void calculateEvenSumBig() {
        assertEquals(
                (long) Integer.MAX_VALUE * 2,
                el6.calculateEvenSum(new int[]{Integer.MAX_VALUE, 3, Integer.MAX_VALUE, -2})
        );
    }

    @Test
    void reverseArray() {
        assertArrayEquals(
                new int[]{4, 3, 2, 1},
                el6.reverseArray(new int[]{1, 2, 3, 4})
        );
    }

    @Test
    void matrixProduct() throws RuntimeException {
        double[][] m1 = new double[1][2];
        double[][] m2 = new double[2][1];
        m1[0][0] = 1.5;
        m1[0][1] = 2;
        m2[0][0] = -1;
        m2[1][0] = 1.5;
        double[][] output = el6.matrixProduct(m1, m2);
        assertEquals(1, output.length);
        assertEquals(1.5, output[0][0]);
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
                assertEquals(sample[i][j], output.get(i).get(j));
            }
        }
    }

    @Test
    void primeFactorsOne() {
        List<Integer> output = el6.primeFactors(1);
        assertEquals(0, output.size());
    }

    @Test
    void primeFactorsPrime() {
        List<Integer> output = el6.primeFactors(13);
        assertEquals(1, output.size());
        assertEquals(13, output.get(0));
    }

    @Test
    void primeFactorsSample() {
        List<Integer> output = el6.primeFactors(120);
        assertEquals(3, output.size());
        assertEquals(2, output.get(0));
        assertEquals(3, output.get(1));
        assertEquals(5, output.get(2));
    }

    @Test
    void extractWord() {
        String line = "hi! how ,are you?";
        List<String> output = el6.extractWord(line);
        assertEquals(4, output.size());
        assertEquals("hi", output.get(0));
        assertEquals("how", output.get(1));
        assertEquals("are", output.get(2));
        assertEquals("you", output.get(3));
    }
}