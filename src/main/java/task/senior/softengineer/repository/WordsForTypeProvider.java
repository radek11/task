package task.senior.softengineer.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WordsForTypeProvider {

    private List<TypeRepository> typeRepositoryList;

    WordsForTypeProvider(List<TypeRepository> typeRepositoryList) {
        this.typeRepositoryList = typeRepositoryList;
    }

    TypeRepository getRepositoryThatCanReturnWordsForType (String typeName) {
        return typeRepositoryList.stream().filter(thingRepository -> thingRepository.couldYouReturnWordsForType(typeName)).findFirst().orElseThrow(() -> new RuntimeException("can't find supported repository for mapping: " + typeName));
    }

    public List<String> getMapping (String mappingName, int count) {
        return new ArrayList<>(getRepositoryThatCanReturnWordsForType(mappingName).getWords(count));
    }

}
