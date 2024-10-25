package file;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("example.txt");

        if(file.exists()){
            System.out.println("File exist!");
        }else {
            file.createNewFile();
            System.out.println("File created");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("Java is a programming language. Java is widely used in web development. Java is popular.");
        writer.close();

        FileReader reader = new FileReader("example.txt");
//        int data;
//        data = reader.read();
//        while ((data = reader.read()) != -1) {
//            System.out.print((char) data);
//        }

        BufferedReader bufferedReader = new BufferedReader(reader);
        HashMap<String, Integer> wordCount = new HashMap<>();
        String line;
        while ((line = bufferedReader.readLine()) != null){

            System.out.println(line);
        }




    }
}
