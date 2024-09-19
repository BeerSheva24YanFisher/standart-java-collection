package telran.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapTasks {

    public static void displayOccurrences(String[] string) {
        //input {"lpm, ab, a, c, cb, cb, c, lpm, lpm"}
        //output:
        // lmp -> 3
        // c -> 2
        // cb -> 2
        // a -> 1
        // ab -> 1
        HashMap<String, Long> map = getMapOccurrences(string);
        TreeMap<Long, TreeSet<String>> sortedMap = getSortedOccurrences(map);
        displaySortedMap(sortedMap);
    }

    private static void displaySortedMap(TreeMap<Long, TreeSet<String>> sortedMap) {
        sortedMap.forEach((occurency,treeSet)-> treeSet.forEach(s -> System.out.printf("%s -> %d \n",s, occurency)));
    }

    private static TreeMap<Long, TreeSet<String>> getSortedOccurrences(HashMap<String, Long> map) {
        TreeMap<Long,TreeSet<String>> result = new TreeMap<>(Comparator.reverseOrder());
        map.entrySet().forEach(e->result.computeIfAbsent(e.getValue(), k-> new TreeSet<>()).add(e.getKey()));
        return result;
    }

    private static HashMap<String, Long> getMapOccurrences(String[] string) {
        HashMap<String,Long> result = new HashMap<>();
        Arrays.stream(string).forEach(s->result.merge(s, 1L, Long::sum));
        return result;
    }

}
