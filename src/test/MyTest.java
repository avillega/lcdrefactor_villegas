package test;

import code.LCDDisplay;
import code.NumberLCD;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MyTest {

    private NumberLCD[] numbers;
    private String number;


    @Before
    public void setUp2(){
        number = "12345676";
        LCDDisplay lcd = new LCDDisplay(2, number);
        numbers = lcd.converToNumberLCD(2, number);
    }



    /**
     * Test if the conversion of a string to a NumberLCD array is made correctlly alse test creation
     */
    @Test
    public void conversionTest(){

        for (int i = 0; i < numbers.length; i++) {
            int digit = number.charAt(i) - '0';
            assertEquals("las diferentes respresentaciones del numero no corresponden",digit, numbers[i].getNumber());
        }
    }



}