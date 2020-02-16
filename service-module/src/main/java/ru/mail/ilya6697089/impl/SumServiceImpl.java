package ru.mail.ilya6697089.impl;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.mail.ilya6697089.SumService;

@Service
public class SumServiceImpl implements SumService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public int add(String numbers) {
        Pattern pattern = Pattern.compile("[ ,:|]");
        String[] words = pattern.split(numbers);

        try {
            int[] array = Arrays.stream(words).mapToInt(Integer::parseInt).toArray();
            return IntStream.of(array).sum();
        } catch (NumberFormatException e) {
            logger.info(e.getMessage(), e);
        }
        return 0;
    }

}
