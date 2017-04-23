package code;

/**
 * Created by Andres Villegas on 2017-04-22.
 * This class has functionality to fill specific segments of a seven segment into a matrix
 */
public class SegmentFiller {

    /**
     * method to fill especific segment of a specified matrix
     * @param segment segment to be filled
     * @param matrix matrix to be filled
     */
    public static void fill(int segment, char[][] matrix){
        int mid = matrix.length/2;
        int col = 0;
        switch(segment){
            case 0:
                fillHorizontal(matrix, 0);
                break;
            case 1:
                col = matrix[0].length-1;
                fillVertical(matrix, col, 1, mid+1);
                break;
            case 2:
                col = matrix[0].length-1;
                fillVertical(matrix, col, mid+1, matrix.length);
                break;
            case 3:
                fillHorizontal(matrix, matrix.length-1);
                break;
            case 4:
                col = 0;
                fillVertical(matrix, col, mid+1, matrix.length);
                break;
            case 5:
                col = 0;
                fillVertical(matrix, col, 1, mid+1);
                break;
            case 6:
                fillHorizontal(matrix, mid);
                break;

        }



    }

    private static void fillHorizontal(char[][] matrix, int index){
        char[] seg = matrix[index];
        //char c = index == 0 ? '-' : '_';
        for (int i = 1; i < seg.length-1; i++) {
            if(i%2 != 0) seg[i] = '_';

        }
    }

    private static void fillVertical(char[][] matrix, int col, int start, int end){
        for (int i = start; i < end ; i++) {
            matrix[i][col] = '|';
        }
    }

}


