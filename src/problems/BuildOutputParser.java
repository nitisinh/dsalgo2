package problems;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// Write a program to parse the output generated for various builds
// 1. Ignore any statements that get printed between the summary markers ==========
// 2. Count the number of warnings in the log, starts with ##[warning]
// 3. Count the number of errors in the log, starts with ##[error]
// 4. Display all the warnings count and print them together
// 5. Display all the errors count and print them together
// =======================================
//  Summary ....
// ##[warning] .. <- Ignore
// ========================================
//  ...
//  ...
//
//  ##[warning] .   ....
//
//  ##[error] ....
//  ##[warning] .....
//  .
//  ##[error] ....
// static int addNumbers(int a, int b) {
//     return a+b;
// }

public class BuildOutputParser {

    private static FileWriter createFileWritterForErrorAndWarning(String fileType){
        //Assume that we have a predefined path to the warning file
        String uri = fileType=="WARNING" ? "warningURI" : "errorURI";
        FileWriter fWritter = null;
        try{
            fWritter = new FileWriter(uri);
        }catch(Exception ex){
            System.out.println("Exception occurred while creating filewritter " + ex.getMessage());
            return fWritter;
        }
        return fWritter;
    }

    public static void parseOutputFile(File outputFile) throws IOException {
        //check the corner case if file exists or not
        if(!outputFile.exists()) {
            System.out.println("File  does not exist or is not reachable");
        }
        //Start reading the file
        FileReader fileReader;
        BufferedReader bReader = null;
        try{
            fileReader = new FileReader(outputFile);
            bReader = new BufferedReader(fileReader);
        }catch(IOException ex){
            System.out.println("Exception occurred while creating the reader of the file");
        }
        //Create regular expression for each patter
        //create list for errors and warnings
        FileWriter warningFileWritter = createFileWritterForErrorAndWarning("WARNING");
        FileWriter errorFileWritter = createFileWritterForErrorAndWarning("ERROR");
        try{
            String newLine;
            Boolean escapeLine = false;
            while((newLine = bReader.readLine())!=null){
                if(newLine.startsWith("==")) escapeLine = !escapeLine;
                if(escapeLine) continue;
                if(newLine.startsWith("##[warning]")){
                    warningFileWritter.append(newLine);
                }
                if(newLine.startsWith("##[error]")){
                    errorFileWritter.append(newLine);
                }
            }
        }catch(IOException ex){
            System.out.println("Exception occurred while reading the file");
        }finally{
            bReader.close();
            errorFileWritter.close();
            warningFileWritter.close();
        }

    }





}