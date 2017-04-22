package code;

/**
 * Created by Andres Villegas on 2017-04-22.
 */
public class NumberLCDFactory {

    private static boolean[][] SEGMENTS = {{true, true, true, true, true, true, false},
                                            {false, true, true, false, false, false, false},
                                            {true, true, false, true, true, false, true},
                                            {true, true, true, true, false, false, true},
                                            {false, true, true, false, false, true, true},
                                            {true, false, true, true, false, true, true},
                                            {true, false, true, true, true, true, true},
                                            {true, true, true, false, false, false, false},
                                            {true, true, true, true, true, true, true},
                                            {true, true, true, false, false, true, true}};


    public static NumberLCD createNumberLCD(int size, int num) {
        NumberLCD ret = new NumberLCD(size, num, SEGMENTS[num]);

        return ret;
    }


}
