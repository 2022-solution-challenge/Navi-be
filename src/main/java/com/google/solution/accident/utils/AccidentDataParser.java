package com.google.solution.accident.utils;

import com.google.solution.accident.domain.AccidentRegion;
import com.google.solution.accident.domain.State;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

@Component
public class AccidentDataParser {
    private static final String FILE_PATH = "./california-data.csv";

    public void parseAccidentData(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        Reader fileReader = new FileReader(resource.getFile());
        CSVReader csvReader = new CSVReader(fileReader);

        String[] nextRecord;
        int num = 10000;
        while ((nextRecord = csvReader.readNext()) != null) {
            if (num == 0) {
                break;
            }
            System.out.println("id : " + nextRecord[0]);
            System.out.println("Severity : " + nextRecord[1]);
            System.out.println("Start_Lat : " + nextRecord[4]);
            System.out.println("Start_Lng : " + nextRecord[5]);
            System.out.println("End_Lat : " + nextRecord[6]);
            System.out.println("End_Lng : " + nextRecord[7]);
            System.out.println("Distance : " + nextRecord[8]);
            System.out.println("Description : " + nextRecord[9]);
            System.out.println("nextRecord = " + nextRecord[10]);
            System.out.println("street = " + nextRecord[11]);
            System.out.println("side = " + nextRecord[12]);
            System.out.println("city = " + nextRecord[13]);
            System.out.println("==========================");
            num--;
        }
    }

    public List<AccidentRegion> parseCaliforniaData() throws IOException {
        ClassPathResource resource = new ClassPathResource("data/california-data.csv");

        InputStream inputStream = resource.getInputStream();

        File newFileForInputStream = File.createTempFile(String.valueOf(inputStream.hashCode()), ".csv");
        newFileForInputStream.deleteOnExit();
        Files.copy(inputStream, newFileForInputStream.toPath(), StandardCopyOption.REPLACE_EXISTING);



        Reader fileReader = new FileReader(newFileForInputStream);
        CSVReader csvReader = new CSVReader(fileReader);

        String[] nextRecord;
        int cnt = 5000;
        List<AccidentRegion> accidentRegions = new ArrayList<>();
        while ((nextRecord = csvReader.readNext()) != null) {

            if (cnt == 0) {
                break;
            }

            if (nextRecord[0].equals("id")){
                continue;
            }
            if (nextRecord.length != 9) {
                continue;
            }

            accidentRegions.add(new AccidentRegion(nextRecord[1], parseDouble(nextRecord[2]),
                    parseDouble(nextRecord[3]), parseDouble(nextRecord[4]),
                    parseDouble(nextRecord[5]), parseDouble(nextRecord[6]),
                    nextRecord[7], State.of(nextRecord[8])));

            cnt --;
        }
        return accidentRegions;
    }

}

