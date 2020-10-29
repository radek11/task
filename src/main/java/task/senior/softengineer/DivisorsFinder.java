package task.senior.softengineer;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
class DivisorsFinder {

    boolean isDivisor (int number, int divisor) {
        return (number % divisor) == 0;
    }

    IntStream findDivisorsForNumberInRange (int number, int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive).filter(value -> isDivisor(number, value));
    }

}
