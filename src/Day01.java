import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day01 {

    public static void main(String[] args) {

        BufferedReader bufferedReader;

        try {
            bufferedReader = Files.newBufferedReader(Path.of("input/input.txt")); //skapar en bufferreader som kan läsa in textfilen
            ArrayList<Integer> depths = new ArrayList<>(); //arraylist för depths
            String line; //en holder för bufferreader
            while((line = bufferedReader.readLine()) !=null) { //kommer läsas så länge nästa linje inte är null
                int depth = Integer.parseInt(line); //en variabel för depth som vi parsar från textfilen till en integer
                depths.add(depth); //lägger in depth i arraylisten som kallas för depths


            }
            int answer = 0; //variabel för svaret för uppgiften
            int previousI = 0; //variabel för förra measurement
            for(int i = 1; i < depths.size(); i++) { //for loop som börjar med startvärde 1 (man kan inte jämföra 0 med något innan det) och går igenom arraylisten och ökar +1 för varje varv
                if(depths.get(i) > previousI) { //om det är så att elementet på nuvarandet indexet är större än det förra så kommer det adderas med +1 hos variabeln för svaret
                    answer++;
                    System.out.println("Current depth: " + depths.get(i) + " Previous depth: " + previousI);
                }

                previousI = depths.get(i); //assign it
            }

            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    }


