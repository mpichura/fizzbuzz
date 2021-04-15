package net.example.fizzbuzz.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FizzBuzzService {

    static final String BUZZ = "buzz";
    static final String FIZZ = "fizz";
    static final String ALFRESCO = "alfresco";
    static final String INTEGER = "integer";
    static final String DELIMITER = ": ";
    static final String SPACE = " ";

    public String step1FizzBuzz(final int startFrom, final int endAt) {
        checkArgumentsCondition(startFrom, endAt);

        final StringBuilder builder = buildResultString(startFrom, endAt, 1);

        return builder.toString().stripTrailing();
    }

    public String step2FizzBuzz(final int startFrom, final int endAt) {
        checkArgumentsCondition(startFrom, endAt);

        final StringBuilder builder = buildResultString(startFrom, endAt, 2);

        return builder.toString().stripTrailing();
    }

    public String step3FizzBuzz(final int startFrom, final int endAt) {
        checkArgumentsCondition(startFrom, endAt);

        final StringBuilder builder = new StringBuilder();
        String step2Results = step2FizzBuzz(startFrom, endAt);
        builder.append(step2Results);
        final int itemsCount = endAt - startFrom + 1;
        builder.append("\n");
        builder.append(countItemsAndWriteToString(step2Results, itemsCount));

        return builder.toString().stripTrailing();
    }

    private String countItemsAndWriteToString(final String input, final int itemsCount) {
        final StringBuilder countBuilder = new StringBuilder();
        final List<String> stringList = List.of(input.split(SPACE));
        final int fizzOccurrences = Collections.frequency(stringList, FIZZ);
        final int buzzOccurrences = Collections.frequency(stringList, BUZZ);
        final int fizzBuzzOccurrences = Collections.frequency(stringList, FIZZ + BUZZ);
        final int alfrescoOccurrences = Collections.frequency(stringList, ALFRESCO);
        final int integerOccurrences =
                itemsCount - (fizzBuzzOccurrences + fizzOccurrences + buzzOccurrences + alfrescoOccurrences);
        countBuilder.append(FIZZ).append(": ").append(fizzOccurrences).append(SPACE);
        countBuilder.append(BUZZ).append(": ").append(buzzOccurrences).append(SPACE);
        countBuilder.append(FIZZ + BUZZ).append(": ").append(fizzBuzzOccurrences).append(SPACE);
        countBuilder.append(ALFRESCO).append(": ").append(alfrescoOccurrences).append(SPACE);
        countBuilder.append(INTEGER).append(DELIMITER).append(integerOccurrences);
        return countBuilder.toString();
    }

    private StringBuilder buildResultString(int startFrom, int endAt, int stepNumber) {
        final StringBuilder builder = new StringBuilder();

        for (int i = startFrom; i <= endAt; i++) {
            if (shouldPutAlfresco(stepNumber, i)) {
                builder.append(ALFRESCO).append(SPACE);
                continue;
            }
            if (isDivisibleBy(i, 3)) {
                builder.append(FIZZ);
            }
            if (isDivisibleBy(i, 5)) {
                builder.append(BUZZ);
            }
            if (!isDivisibleBy(i, 3) && !isDivisibleBy(i, 5)) {
                builder.append(i);
            }
            builder.append(SPACE);

        }
        return builder;
    }

    private boolean shouldPutAlfresco(int stepNumber, int number) {
        return stepNumber == 2 && String.valueOf(number).contains("3");
    }

    private void checkArgumentsCondition(int startFrom, int endAt) {
        if (endAt < startFrom) {
            throw new IllegalArgumentException(
                    String.format("End of loop (%s) smaller than beggining (%s)", endAt, startFrom));
        }
    }

    private boolean isDivisibleBy(final int number, final int divisor) {
        return number % divisor == 0;
    }


}
