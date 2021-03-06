package code;

import java.util.Arrays;

/**
 * Created by Andres Villegas on 2017-04-21.
 * Interface that specifies the functionalities of all number implementations
 * For the representation it uses a 7-segment representation, this means. the first segment is at top, then go clockwise,
 * leaving the middle segment as the last segment
 *
 *       _0_
 *   5 |   | 1
 *    |_6_|
 *  4|   | 2
 *  |_ _|
 *    3
 */
public class NumberLCD {

    private char[][] matrix;
    private boolean[] segments;
    private int size;
    private int number;


    public NumberLCD(int size, int number, boolean[] segments) {
        this.size = size;
        this.matrix = new char[2*size + 1][(2*size)+1];
        this.segments = segments;
        this.number = number;
        //Fill the marix with spaces
        for (char[] c: matrix) {
            Arrays.fill(c, ' ');
        }
        buildMatrix();


    }

    int numberRows(){
        return matrix.length;
    }
    public int numberCols(){
        return matrix[0].length;
    }

    public char[][] getMatrixRespresentation(){
        return matrix;
    }
    public boolean[] getSegments(){
        return segments;
    }

    public void setSegments(boolean[] segments){
        this.segments = segments;

    }

    /**
     * get the specific row in its string representation
     * @param row to be returned
     * @return String representation of the specfic row
     */
    public String getRowAsString(int row){
        return new String(matrix[row]);
    }

    /**
     * build the matrix with the segments setted to true
     */
    private void buildMatrix(){
        for (int i = 0; i < segments.length; i++) {
            if(segments[i]) SegmentFiller.fill(i, matrix);
        }
    }

    public int getNumber() {
        return number;
    }
}
