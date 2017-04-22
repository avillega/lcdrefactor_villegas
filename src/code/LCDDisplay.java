package code;

import java.io.*;

public class LCDDisplay {

    private NumberLCD[] numero;
    private int size;

    public LCDDisplay(int size, String numero) {
        this.numero = converToNumberLCD(size, numero);
    }

    public String getString(){
        int rows = numero[0].numberRows();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numero.length; j++) {
                stb.append(numero[j].getRowAsString(i) + "  ");
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
        for (int i = 0; i < num.length(); i++) {
            //Converts the char to int
            int digit = num.charAt(i) - '0';
            ret[i] = NumberLCDFactory.createNumberLCD(size, digit);
        }
        return ret;
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
                int temp = Integer.parseInt(vals[1]);
                if(size == 0 || temp == 0) break;
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
