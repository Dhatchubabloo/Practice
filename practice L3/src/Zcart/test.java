package Zcart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("/home/inc5/IdeaProjects/Practice/practice L3/src/Zcart/zusers.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null){

        }
        fr.close();
    }
}
