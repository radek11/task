package task.senior.softengineer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/** automation test - but better real automation test using selenium or other tool */
@SpringBootTest
class MappingApplicationTest {

    @Autowired
    private MappingApplication mappingApplication;

    @Test
    void getUserOutputForAnimals() {

        assertEquals("{1=[Mouse]}", mappingApplication.getUserOutput("Animals", Arrays.asList(MappingApplication.MIN_RANGE)).toString());
        assertEquals("{1=[Mouse], 2=[Mouse, Cat]}", mappingApplication.getUserOutput("Animals", Arrays.asList(1, 2)).toString());
        assertEquals("{1=[Mouse], 2=[Mouse, Cat], 4=[Mouse, Cat, Elephant]}", mappingApplication.getUserOutput("Animals", Arrays.asList(1, 2, 4)).toString());
        assertEquals("{20=[Mouse, Cat, Elephant, Tiger, Bug, Blue sheep]}", mappingApplication.getUserOutput("Animals", Arrays.asList(MappingApplication.MAX_RANGE)).toString());
    }

    @Test
    void getUserOutputForFurnitures() {

        assertEquals("{1=[Chair]}", mappingApplication.getUserOutput("Furnitures", Arrays.asList(MappingApplication.MIN_RANGE)).toString());
        assertEquals("{1=[Chair], 2=[Chair, Table]}", mappingApplication.getUserOutput("Furnitures", Arrays.asList(1, 2)).toString());
        assertEquals("{1=[Chair], 2=[Chair, Table], 4=[Chair, Table, Bed]}", mappingApplication.getUserOutput("Furnitures", Arrays.asList(1, 2, 4)).toString());
    }

    @Test
    void testErrors () {

        Exception ex = assertThrows(RuntimeException.class, () -> mappingApplication.getUserOutput("not existed mapping", Arrays.asList(1)));
        assertEquals("can't find supported repository for mapping: not existed mapping", ex.getMessage());
    }

}