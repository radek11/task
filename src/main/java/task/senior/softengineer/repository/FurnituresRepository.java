package task.senior.softengineer.repository;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
class FurnituresRepository implements TypeRepository {

    private static final String MAPPING_NAME = "Furnitures";

    @Override
    public LinkedHashSet<String> getWords(int count) {
        String[] furnitures = new String[]{"Chair", "Table", "Cabinet", "Bed", "Sofa", "Futon", "Rocking chair"};
        return new LinkedHashSet<>(Arrays.asList(furnitures));
    }

    @Override
    public boolean couldYouReturnWordsForType(String mapping) {
        return MAPPING_NAME.equals(mapping);
    }
}
