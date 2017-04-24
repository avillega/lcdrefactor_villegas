package code;

import java.io.*;

public class LCDDisplay {

    private NumberLCD[] numero;
    private int size;

    public LCDDisplay(int size, String numero) {
        this.numero = converToNumberLCD(size, numero);
    }


    /**
     * returns the representation of a number as a String
     * @return String: the string represetantion as a 7 segment LCD display
     */
    public String getString(){
        int rows = numero[0].numberRows();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (NumberLCD aNumero : numero) {
                stb.append(aNumero.getRowAsString(i)).append(" ");
            }

            stb.append(System.lineSeparator());
        }
        return stb.toString();
    }

    /**
     * method to convert form a string to a representation in 7 segments
     * Pre: num must be a number in base 10 in string format. This mehtos is intent to be called inside the construction of LCDDisplay only, if it is public is
     * for testing reasons
     * @param size: size of the lcd display
     * @param num: number to be converted
     * @return an array of NumberLCD corresponding to the nimber passed as paramter
     */
    public NumberLCD[] converToNumberLCD(int size,String num){
        NumberLCD[] ret = new NumberLCD[num.length()];
        isNumber(num);
        for (int i = 0; i < num.length(); i++) {
            //Converts the char to int
            int digit = num.charAt(i) - '0';
            ret[i] = NumberLCDFactory.createNumberLCD(size, digit);
        }
        return ret;
    }

    public boolean isNumber(String test){
        char[] temp = test.toCharArray();
        for (char c: temp) {
            if(!Character.isDigit(c)) throw new NumberFormatException("the string is not a number");
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        out.println("Bienvnido a el lcd display");
        out.println("Para empezar escriba el tamano de pantalla que desea (entre 1 y 10) y el numero en formato decimal que desea mostrar, separados por comas");
        out.println("Para terminar escriba 0,0");
        out.flush();

        String ln;
        while(true){
            ln = in.readLine();
            String[] vals = ln.split(",");
            try{
                int size = Integer.parseInt(vals[0]);

                if(size == 0 || vals[1].equals("0")) break;
                String num = vals[1];
                LCDDisplay lcd = new LCDDisplay(size, num);
                out.write(lcd.getString());
                out.println();
                out.flush();
            }catch(Exception e){
                out.println("recuerde que ambos numeros deben ser digitos en base 10 (0123456789) y separados por comas");
                //e.printStackTrace();
                out.flush();
            }
        }
        in.close();
        out.close();
    }




}
