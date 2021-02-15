package sbu.cs;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseLecture5Test {

    static ExerciseLecture5 el5;

    @BeforeAll
    static void setUp() {
        el5 = new ExerciseLecture5();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 20})
    void weakPassword(int len) {
        String output = el5.weakPassword(len);
        assertEquals(len, output.length());
        assertTrue(output.matches("[a-z]*"));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    void strongPassword(int len) throws Exception {
        String output = el5.strongPassword(len);
        assertEquals(len, output.length());
        assertTrue(checkStrongPass(output));
    }

    @RepeatedTest(value = 20, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("strongPasswordTest")
    void strongPasswordRepeat(RepetitionInfo repInfo, TestInfo testInfo) throws Exception {
        String output = el5.strongPassword(3);
        assertEquals(3, output.length());
        assertTrue(checkStrongPass(output));
    }

    @Test
    void strongPasswordBadLength() {
        assertThrows(Exception.class, () -> el5.strongPassword(2));
    }

    boolean checkStrongPass(String password) {
        boolean alpha = false, digit = false, special = false;
        String allLower = "abcdefghijklmnopqrstuvwxyz";
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digit = true;
            } else if (allLower.indexOf(Character.toLowerCase(c)) != -1) {
                alpha = true;
            } else {
                special = true;
            }
        }
        return alpha && digit && special;
    }

    @Test
    void isFiboBinTrue() {
        assertTrue(el5.isFiboBin(2));
    }

    @Test
    void isFiboBinFalse() {
        assertFalse(el5.isFiboBin(3));
    }
}