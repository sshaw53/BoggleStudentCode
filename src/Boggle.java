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

        // Call the DFS for each spot on the board
        String prefix = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, prefix, dict_tst, goodWords);
            }
        }

        // Convert the list into a sorted array of strings, then return the array
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void dfs(char[][] board, int i, int j, String prefix, TST dict_tst, ArrayList<String> goodWords) {
        // Base cases: out of board, no longer a prefix, or already visited
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '-') {
            return;
        }

        TST_Node current_lookup = dict_tst.lookup(prefix);
        if (current_lookup == null || (current_lookup != null && !current_lookup.isPrefix())) {
            return;
        }

        // Now check for the word adding the current letter
        char current_character = board[i][j];
        String new_prefix = prefix + current_character;
        TST_Node next_lookup = dict_tst.lookup(new_prefix, current_lookup);

        // If it's in the dictionary TST, add it to the ArrayList
        if (next_lookup != null && next_lookup.isWord()) {
            // Set isWord to false if we find the word so that we avoid duplicates
            dict_tst.setWordFalse(next_lookup);
            goodWords.add(new_prefix);
        }

        // Mark the spot as visited
        board[i][j] = '-';

        // Call recursive algorithm
        dfs(board, i + 1, j, new_prefix, dict_tst, goodWords);
        dfs(board, i - 1, j, new_prefix, dict_tst, goodWords);
        dfs(board, i, j + 1, new_prefix, dict_tst, goodWords);
        dfs(board, i, j - 1, new_prefix, dict_tst, goodWords);

        // Reset to be unvisited
        board[i][j] = current_character;
    }
}
