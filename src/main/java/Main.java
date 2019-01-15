import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main (String [ ] args) throws IOException {
        LinkedList<Integer> numeros = new LinkedList<Integer>();
        float mean = 0;
        float deviation = 0;
        int content;
        File file = new File("src/data.txt");
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()){
                content = Integer.parseInt(sc.nextLine());
                numeros.add(content);
            }
            sc.close();
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nProgram terminated Safely...");
        }


        for (int i =0; i < numeros.size(); i++) {
            mean = mean  + numeros.get(i);
        }

        mean = mean/numeros.size();

        for (int i =0; i < numeros.size(); i++) {
            deviation = (float) (deviation  + Math.pow((numeros.get(i) - mean),2));
        }


        deviation = (float) Math.sqrt(deviation/(numeros.size()-1));
        System.out.println("Mean: " + mean);
        System.out.println("Deviation: " + deviation);
    }

}
