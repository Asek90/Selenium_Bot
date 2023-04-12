package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AgreementComparer {

    public static String getAgreementFromFile(File agreementFile){
        Scanner FileReader = null;
        try {
            FileReader = new Scanner(agreementFile, StandardCharsets.UTF_8.name());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String agreement = FileReader.useDelimiter("\\A").next();
        FileReader.close();

        return agreement;
    }
}
