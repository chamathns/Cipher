package sample;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static sample.Controller.filePath;

public class FileController {
    private String slectedFile, savedFile;
    private static FileController instance = new FileController();
    public static String everything, output;
    private static FileWriter fw = null;


    public FileController getInstance(){
        return instance;
    }

    public static void fileReader(String selectedFile) throws IOException{
        try(FileInputStream inputStream = new FileInputStream(selectedFile)) {
             everything = IOUtils.toString(inputStream);
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
    public static void fileWriter(String savedFile , String value) throws IOException{
        try {
            fw = new FileWriter(savedFile);
            IOUtils.write(value,fw);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(fw);
        }

    }
}
