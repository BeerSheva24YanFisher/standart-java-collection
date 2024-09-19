package telran.collections;

import org.junit.jupiter.api.Test;

import static telran.collections.MapTasks.displayOccurrences;

public class MapTasksTest {

    @Test
    void displayOccurrencesTest(){
        String[] string = {"lpm", "ab", "a", "c", "cb", "cb", "c", "lpm", "lpm"};
        displayOccurrences(string);
    }

}
