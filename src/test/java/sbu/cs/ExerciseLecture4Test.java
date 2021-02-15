package sbu.cs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseLecture4Test {

    static ExerciseLecture4 el4;

    @BeforeAll
    static void setUp() {
        el4 = new ExerciseLecture4();
    }

    @Test
    void factorialSimple1() {
        assertEquals(120, el4.factorial(5));
    }

    @Test
    void factorialSimple2() {
        assertEquals(1, el4.factorial(1));
    }

    @Test
    void factorialOfZero() {
        assertEquals(1, el4.factorial(0));
    }

    @Test
    void fibonacciSample1() {
        assertEquals(5, el4.fibonacci(5));
    }

    @Test
    void fibonacciSample2() {
        assertEquals(1, el4.fibonacci(1));
    }

    @Test
    void fibonacciSample3() {
        assertEquals(1, el4.fibonacci(2));
    }

    @Test
    void fibonacciBigIndex() {
        // It's actually a prime number
        assertEquals(2971215073L, el4.fibonacci(47));
    }

    @Test
    void reverseSample1() {
        assertEquals("olleh", el4.reverse("hello"));
    }

    @Test
    void reverseSample2() {
        assertEquals("wow", el4.reverse("wow"));
    }

    @Test
    void reverseCaseImportant() {
        assertEquals("Ila", el4.reverse("alI"));
    }

    @Test
    void reverseWithSpace() {
        assertEquals(
                "neve ro ddo reven",
                el4.reverse("never odd or even"));
    }

    @Test
    void isPalindrome() {
        assertTrue(el4.isPalindrome("wow"));
    }

    @Test
    void isPalindromeIgnoreCase() {
        assertTrue(el4.isPalindrome("Wow"));
    }

    @Test
    void isPalindromeLine() {
        assertTrue(el4.isPalindrome("never odd or even"));
    }

    @Test
    void isPalindromeWrong1() {
        assertFalse(el4.isPalindrome("hello"));
    }

    @Test
    void isPalindromeWrong2() {
        assertFalse(el4.isPalindrome("kabab"));
    }

    @Test
    void dotPlotSample1() {
        char[][] answer = makeEmptyArray(5, 5);
        char[][] output = el4.dotPlot("hello", "hello");
        answer[0][0] = '*';
        answer[1][1] = '*';
        answer[2][2] = '*';
        answer[3][3] = '*';
        answer[4][4] = '*';
        answer[2][3] = '*';
        answer[3][2] = '*';
        for (int i = 0; i < 5; i++) {
            assertArrayEquals(answer[i], output[i]);
        }
    }

    @Test
    void dotPlotSample2() {
        char[][] answer = makeEmptyArray(2, 4);
        char[][] output = el4.dotPlot("hi", "help");
        answer[0][0] = '*';
        for (int i = 0; i < 2; i++) {
            assertArrayEquals(answer[i], output[i]);
        }
    }

    char[][] makeEmptyArray(int dim1, int dim2) {
        char[][] arr = new char[dim1][dim2];
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }
}