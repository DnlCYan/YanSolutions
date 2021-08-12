package pt.yan.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void defaultIfNull() {
        ClassA a = new ClassA();
        String out = ValidationUtils.defaultIfNull(() -> {return a.getString();}, "testDefault");
        assertEquals("testA", out);
    }

    @Test
    void defaultIfNull_Exception() {
        ClassA a = null;
        String out = ValidationUtils.defaultIfNull(() -> {return a.getString();}, "testDefault");
        assertEquals("testDefault", out);
    }

    @Test
    void defaultIfNull_Default() {
        ClassA a = new ClassA();
        String out = ValidationUtils.defaultIfNull(() -> {return a.getNullString();}, "testDefault");
        assertEquals("testDefault", out);
    }

    class ClassA{
        public String getString(){ return "testA";}
        public String getNullString(){ return null;}
    }
}