package task.senior.softengineer;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApplicationController {

    MappingApplication mappingApplication;

    public ApplicationController(MappingApplication mappingApplication) {
        this.mappingApplication = mappingApplication;
    }

    /** request should be in pattern eg. localhost:8080/Animals 1 2 4 */
    @GetMapping("/{input}")
    public String index(@PathVariable("input") String input) {
        String[] splittedInput = input.split(" ");
        List<Integer> numbers = Arrays.stream(splittedInput).filter(s -> isNumber(s)).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        try {
            return mappingApplication.getUserOutput(splittedInput[0], numbers).toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    boolean isNumber (String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
