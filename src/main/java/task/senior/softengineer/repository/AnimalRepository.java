package task.senior.softengineer.repository;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashSet;

@Component
class AnimalRepository implements TypeRepository {

    static final String MAPPING_NAME = "Animals";

    @Override
    public LinkedHashSet<String> getWords(int count) {
        String[] animals = new String[]{"Mouse", "Cat", "Dog", "Elephant", "Tiger", "Turtle", "Bear", "Bat", "Bird", "Bug", "Puma", "Deer", "Fox", "Bear", "Goat", "Bison", "Black impala", "Blackbuck", "Blackcock", "Sheep", "Blue sheep", "Hyena", "Camel", "Fox", "Zebra", "Coyote" };
        return new LinkedHashSet<String>(Arrays.asList(animals));
    }

    @Override
    public boolean couldYouReturnWordsForType(String mapping) {
        return MAPPING_NAME.equals(mapping);
    }


}
