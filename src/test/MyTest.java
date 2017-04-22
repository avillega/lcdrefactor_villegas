package test;

import code.LCDDisplay;
import code.NumberLCD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyTest {

    private NumberLCD[] numbers;
    private String number;
    private LCDDisplay lcd;

    private void setUp1() {
        lcd = new LCDDisplay(2, "1234567890");
    }


    public void setUp2() {
        number = "12345676";
        lcd = new LCDDisplay(2, number);
        numbers = lcd.converToNumberLCD(2, number);
    }


    /**
     * Test if the conversion of a string to a NumberLCD array is made correctlly alse test creation
     */
    @Test
    public void conversionTest() {
        setUp2();
        for (int i = 0; i < numbers.length; i++) {
            int digit = number.charAt(i) - '0';
            assertEquals("las diferentes respresentaciones del numero no corresponden", digit, numbers[i].getNumber());
        }
    }

    @Test
    public void representationTest() {
        setUp1();
        String exp= "       _ _   _ _         _ _   _ _   _ _   _ _   _ _   _ _  " +System.lineSeparator()+
                    "    |     |     | |   | |     |         | |   | |   | |   | " +System.lineSeparator()+
                    "    |  _ _|  _ _| |_ _| |_ _  |_ _      | |_ _| |_ _| |   | " +System.lineSeparator()+
                    "    | |         |     |     | |   |     | |   |     | |   | " +System.lineSeparator()+
                    "    | |_ _   _ _|     |  _ _| |_ _|     | |_ _|     | |_ _| "+System.lineSeparator();

        String actual = lcd.getString();

        assertEquals("las representaciones no son iguales", exp, actual);


    }


}