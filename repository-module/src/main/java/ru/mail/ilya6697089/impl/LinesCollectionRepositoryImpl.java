package ru.mail.ilya6697089.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Repository;
import ru.mail.ilya6697089.LinesCollectionRepository;

@Repository
public class LinesCollectionRepositoryImpl implements LinesCollectionRepository {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public List<String> getLinesCollection(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            List<String> linesList = new ArrayList<>();
            String line = reader.readLine();
            do {
                linesList.add(line);
                line = reader.readLine();
            } while (line != null);
            logger.info("========== " + linesList + " ==========");
            return linesList;
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

}
