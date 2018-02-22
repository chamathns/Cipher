package sample;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static sample.Controller.filePath;


public class FileController {
    public static String everything;

    public static void fileReader() throws IOException{
//        byte bytes[] = FileUtils.readFileToByteArray(file);
        try(FileInputStream inputStream = new FileInputStream(filePath)) {
             everything = IOUtils.toString(inputStream);
            // do something with everything string
        }finally {
            {
                System.out.println(everything);
            }
        }
//        Path path = Paths.get(filePath);
//        BufferedReader br = Files.newBufferedReader(path);
//
//        try{
//            StringBuilder stringBuilder = new StringBuilder();
//            String input = br.readLine();
//            while (input != null){
//                stringBuilder.append(input);
//                stringBuilder.append(System.lineSeparator());
//                input = br.readLine();
//            }
//            everything = stringBuilder.toString();
//        } finally {
//            if (br != null){
//                br.close();
//            }
//        }

    }

    public  static void fileWriter() throws IOException{


    }
}
