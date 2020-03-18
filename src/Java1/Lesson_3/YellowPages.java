package Java1.Lesson_3;

import java.util.HashMap;
import java.util.HashSet;

public class YellowPages {
    private  HashMap <String, HashSet<String>> yellowPages = new HashMap<>();

    public  void add(String name, HashSet<String> phoneNumbers){
        yellowPages.put(name,phoneNumbers);
    }

    public HashSet<String> get(String name){
        return yellowPages.get(name);
    }
}