import java.io.*;
import java.util.Scanner;
public class StudentReportSystem {

        public static void main(String[] args) {
            String fileName = "students.txt";
            Scanner sc = new Scanner(System.in);

            try {
                
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Roll Number: ");
                int rollNumber = Integer.parseInt(sc.nextLine()); // handle input as int

                System.out.print("Enter Marks: ");
                double marks = Double.parseDouble(sc.nextLine()); // handle input as double

                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                    writer.write(name + "," + rollNumber + "," + marks);
                    writer.newLine();
                    System.out.println("Student details saved successfully!\n");
                }

                
                System.out.println("---- Student Records ----");
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        System.out.println("Name: " + data[0] + ", Roll No: " + data[1] + ", Marks: " + data[2]);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values for Roll Number and Marks.");
            } catch (IOException e) {
                System.out.println("Error while handling the file: " + e.getMessage());
            } finally {
                sc.close();
            }
        }
    }


