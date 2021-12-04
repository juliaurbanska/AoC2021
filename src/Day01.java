import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day01 {



    public static void main(String[] args) {

        BufferedReader bufferedReader;
        ArrayList<Integer> depths = new ArrayList<>(); //arraylist for depths

        try {
            bufferedReader = Files.newBufferedReader(Path.of("input/input.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) { //kommer läsas så länge nästa linje inte är null
                int depth = Integer.parseInt(line); //en variabel för depth som vi parsar från textfilen till en integer
                depths.add(depth); //lägger in depth i arraylisten som kallas för depths


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        //Method for part one and method for part two
        partOne(depths);
        partTwo(depths);



    }

    private static void partTwo(ArrayList<Integer> depths) {
        int count = 0;
        int previousGroup = 0;


        //for loop för att gå igenom listan och för varje varv så ska den kolla ifall den nuvarande summan är större än den förra, om ja så lägg till en count.

        //variabel som representerar tre värden i varje grupp, föregående värdet i listan är första värdet i gruppen.
        //eftersom första gruppens sista värde ligger på 2 (0,1,2) så är startvärdet 2 i for-loopen
        // -1 i svaret så är första gången man jämför med grupp A och där finns det inget värde att jämföra. och en for loop adderar för varje varv det blir en gång för mycket per se.

        for (int i = 2; i < depths.size(); i++) {
            int currentGroup = depths.get(i - 2) + depths.get(i - 1) + depths.get(i);
            if (currentGroup > previousGroup && previousGroup != 0) {
                count++;
            }
            previousGroup = currentGroup;
        }

        System.out.println("Part 2: " + count);

    }


    private static void partOne(ArrayList<Integer> depths) {
        int answer = 0; //variabel för svaret för uppgiften
        int previousI = 0; //variabel för förra measurement
        for (int i = 1; i < depths.size(); i++) { //for loop som börjar med startvärde 1 (man kan inte jämföra 0 med något innan det) och går igenom arraylisten och ökar +1 för varje varv
            if (depths.get(i) > previousI) { //om det är så att elementet på nuvarandet indexet är större än det förra så kommer det adderas med +1 hos variabeln för svaret
                answer++;
            }

            previousI = depths.get(i); //assign it
        }

        System.out.println("Part 1: " + answer);
    }


}



