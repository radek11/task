package task.senior.softengineer.repository;

import java.util.LinkedHashSet;

/** repository of words for some type eg. animal, furniture  */
interface TypeRepository {

    boolean couldYouReturnWordsForType(String typeName);

    /** mapping number - is index +1 */
    LinkedHashSet<String> getWords(int count);
}
