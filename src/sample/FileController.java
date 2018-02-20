package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static sample.Controller.filePath;


public class FileController {
    public static String everything;

    public static void fileReader() throws IOException{
        Path path = Paths.get(filePath);
        BufferedReader br = Files.newBufferedReader(path);

        try{
            StringBuilder stringBuilder = new StringBuilder();
            String input = br.readLine();
            while (input != null){
                stringBuilder.append(input);
                stringBuilder.append(System.lineSeparator());
                input = br.readLine();
//                System.out.println(br.readLine());
            }
            everything = stringBuilder.toString();
        } finally {
            if (br != null){
                br.close();
            }
        }
        System.out.println(everything);
    }
}
