package sbu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TallyCounterTest {

    TallyCounter tallyCounter;

    @BeforeEach
    void setUp() throws IllegalValueException {
        this.tallyCounter = new TallyCounter();
        this.tallyCounter.setValue(0);
    }

    @Test
    void count() {
        this.tallyCounter.count();
        assertEquals(this.tallyCounter.getValue(), 1);
    }

    @Test
    void countNotFromZero() {
        this.tallyCounter.setValue(99);
        this.tallyCounter.count();
        assertEquals(this.tallyCounter.getValue(), 100);
    }

    @Test
    void countMax() {
        this.tallyCounter.setValue(9999);
        this.tallyCounter.count();
        assertEquals(this.tallyCounter.getValue(), 9999);
    }

    @Test
    void getValue() {
        assertEquals(this.tallyCounter.getValue(), 0);
    }

    @Test
    void getValueNotZero() {
        this.tallyCounter.setValue(33);
        assertEquals(this.tallyCounter.getValue(), 33);
    }

    @Test
    void getValueMax() {
        this.tallyCounter.setValue(9999);
        assertEquals(this.tallyCounter.getValue(), 9999);
    }

    @Test
    void setValue() {
        this.tallyCounter.setValue(13);
        assertEquals(this.tallyCounter.getValue(), 13);
    }

    @Test
    void setNegativeValue() {
        assertThrows(IllegalValueException.class,
                () -> this.tallyCounter.setValue(-1));
    }

    @Test
    void setBigValue() {
        assertThrows(IllegalValueException.class,
                () -> this.tallyCounter.setValue(10000));
    }
}