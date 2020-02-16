package ru.mail.ilya6697089;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import ru.mail.ilya6697089.impl.SumOfFileLinesImpl;

@Controller
public class Runner {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final String FILE_NAME = "fileName";

    public static void main(String[] args) {

        PropertyUtil propertyUtil = new PropertyUtil();
        SumOfFileLinesImpl sumOfFileLines = new SumOfFileLinesImpl();
        Integer resultOfWorkingThisMethod = sumOfFileLines.getSumOfFileLines(propertyUtil.getProperty(FILE_NAME));
        logger.info("======== Sum of all values = " + resultOfWorkingThisMethod + " ========");

    }

}
