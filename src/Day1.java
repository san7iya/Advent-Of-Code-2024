import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String args[]) {
        try {
            BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\hp5cd\\OneDrive\\Desktop\\AOC-2024\\Advent-Of-Code-24\\src\\input.txt")); //read file contents

            List<Integer> list1 = new ArrayList<>(); 
            List<Integer> list2 = new ArrayList<>();

            String input;
            while ((input = file.readLine())!= null) {
                if (input.isEmpty()) { 
                    continue;
                }

                try {
                    String[] s = input.split("\\s+");

                    for (int i = 0; i < s.length; i++) {
                        int num = Integer.parseInt(s[i]);

                        if (i % 2 == 0) {
                            list1.add(num);
                        } else {
                            list2.add(num);
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid");
                }
            }

            file.close();

            //part1 solution 
            Collections.sort(list1);
            Collections.sort(list2);

            //calculates the total distance between the two lists 
            int sum = 0;
            for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                sum += Math.abs(list1.get(i) - list2.get(i));
            }
            
            System.out.printf("The total distance between the two lists: %d\n", sum);

            //part 2 solution
            //calculates similarity score
            int count, sim = 0; 
            for (int i = 0; i < list1.size(); i++) {
                count = 0; 
                for (int j = 0; j < list2.size(); j++) {
                    if (list1.get(i).equals(list2.get(j))) { 
                        count++;
                    }
                }
                sim += list1.get(i) * count; 
            }

            System.out.printf("Similarity Score: %d\n", sim);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}
