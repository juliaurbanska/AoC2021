import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day02 {
    private int horizontal = 0;
    private int depth = 0;
    private int aim = 0;
    ArrayList<String> commands = new ArrayList<>();


    public static void main(String[] args) {

        Day02 day2 = new Day02();
        day2.run();
        day2.run2();
    }

    //method for part 2, very similiar to part 1
    private void run2() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(Path.of("inputday2.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                commands.add(line);

            }
            //go through our list of directions
            for (String s: commands) {

                String [] instruction = s.split(" ");
                //switch statement on what the first part of the instruction is
                switch (instruction[0]) {

                    case "up":
                        aim -= Integer.parseInt(instruction[1]); //index 1 för det är "andra" delen av instuktionen, alltså siffra. depth = depth + Integer.parseInt(instruction[1]);
                        break;
                    case "down":
                        aim += Integer.parseInt(instruction[1]);
                        break;
                    case "forward":
                        horizontal += Integer.parseInt(instruction[1]);
                        depth += aim * Integer.parseInt(instruction[1]);
                        break;
                }

            }


            System.out.println(horizontal * depth);

        }



        catch (Exception e) {
            e.printStackTrace();
        }





    }


    //method for part 1
    private void run() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(Path.of("inputday2.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                commands.add(line);

            }
            //go through our list of directions
            for (String s: commands) {

                String [] instruction = s.split(" ");
                //switch statement on what the first part of the instruction is
                switch (instruction[0]) {

                    case "up":
                        depth -= Integer.parseInt(instruction[1]); //index 1 för det är "andra" delen av instuktionen, alltså siffra. depth = depth + Integer.parseInt(instruction[1]);
                        break;
                    case "down":
                        depth += Integer.parseInt(instruction[1]);
                        break;
                    case "forward":
                        horizontal += Integer.parseInt(instruction[1]);
                        break;
                }

            }

            System.out.println(horizontal * depth);


        }



        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
