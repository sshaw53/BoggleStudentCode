import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // Create a TST for the dictionary
        TST dict_tst = new TST();

        // For each word in the dictionary, insert it into the TST
        for (String word : dictionary) {
            dict_tst.insert(word);
        }

        // Find a way to traverse through the letters in board (BFS)

        // 2D array of booleans, as I go down a path, I start setting each step in my path as true, if I pivot,
        // I set that current spot as false and set something new as true - one of the next possible spots from the
        // spot before

        // Find a way to make sure that it knows there's more to go in the TST

        // if not in dictionary TST and not in misspelled TST, add the word to misspelled TST
        if (dict_tst.lookup(word)) {
            goodWords.add(word);
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }
}
