package ru.mail.ilya6697089.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import ru.mail.ilya6697089.SumOfFileLines;

@Service
public class SumOfFileLinesImpl implements SumOfFileLines {

    @Override
    public Integer getSumOfFileLines(String fileName) {
        LinesCollectionRepositoryImpl linesCollectionRepository = new LinesCollectionRepositoryImpl();
        SumServiceImpl sumService = new SumServiceImpl();
        List<String> listOfLines = linesCollectionRepository.getLinesCollection(fileName);
        int sumOfLinesValues = 0;
        for (String numbers : listOfLines) {
            sumOfLinesValues += sumService.add(numbers);
        }
        return sumOfLinesValues;
    }

}
