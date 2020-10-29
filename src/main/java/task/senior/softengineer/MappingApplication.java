package task.senior.softengineer;


import org.springframework.stereotype.Component;
import task.senior.softengineer.repository.WordsForTypeProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
class MappingApplication {

    private DivisorsFinder divisorsFinder;
    private WordsForTypeProvider wordsForTypeProvider;

    final static int MIN_RANGE = 1;
    final static int MAX_RANGE = 20;

    MappingApplication(WordsForTypeProvider wordsForTypeProvider, DivisorsFinder divisorsFinder) {
        this.wordsForTypeProvider = wordsForTypeProvider;
        this.divisorsFinder = divisorsFinder;
    }

    Map<Integer, List<String>> getUserOutput (String mappingName, List<Integer> numbers) {
        List<String> thingMapping = wordsForTypeProvider.getMapping(mappingName, MAX_RANGE);

        Map<Integer, List<String>> mappedNumbersToThings = new HashMap<>();

        numbers.stream().forEach(number -> {
            IntStream divisorsForNumberInRange = divisorsFinder.findDivisorsForNumberInRange(number, MIN_RANGE, MAX_RANGE);
            List<String> thingsMapped = divisorsForNumberInRange.mapToObj(value -> thingMapping.get(value - 1)).collect(Collectors.toList());
            mappedNumbersToThings.put(number, thingsMapped);
        });
        return mappedNumbersToThings;
    }

}
