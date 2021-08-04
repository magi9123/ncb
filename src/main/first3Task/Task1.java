package first3Task;

import java.util.HashSet;
import java.util.Set;

/**
 * Write Java program to find duplicate characters in a string.
 */
public class Task1 {
    public static void main(String[] args) {

        String word = "vvvvvv";// "abcdlabdla";
        Set<String> characters = repeatedCharacters(word);
        characters.stream().forEach(System.out::println);
    }

    public static Set<String> repeatedCharacters(String word) {
        Set<String> characters = new HashSet<>();

        int sliceSize = 2;

        do {

            for (int i = 0; i < word.length() - sliceSize && sliceSize <= word.length() / 2; i++) {


                String slice = word.substring(i, i + sliceSize).toString();
                String remainder = word.substring(i + sliceSize);
                if (remainder.contains(slice)) {
                    characters.add(slice);
                    slice = "";
                    remainder = "";
                }
            }
            sliceSize++;

        } while (sliceSize <= word.length());


        return characters;
    }
}
