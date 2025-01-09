import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // Create a TST for the dictionary
        Trie dict_trie = new Trie();

        // For each word in the dictionary, insert it into the TST
        for (String word : dictionary) {
            dict_trie.insert(word);
        }
        String prefix = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String word = dfs(board, i, j, prefix, dict_trie);

                // If it's in the dictionary, add the word to goodWords ArrayList
                if (dict_trie.lookup(word)) {
                    goodWords.add(word);
                }
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static String dfs(char[][] board, int i, int j, String prefix, Trie dict_trie) {
        // Base cases: out of board, no longer a prefix, or already visited
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) { return prefix; }
        //********** how to look for prefixes
        if (dict_trie) { return prefix; }
        if (board[i][j] == '-') { return prefix; }

        char current_character = board[i][j];

        // Mark the spot as visited
        board[i][j] = '-';

        String new_prefix = prefix + current_character;

        // Call recursive algorithm
        dfs(board, i + 1, j, new_prefix, dict_trie);
        dfs(board, i - 1, j, new_prefix, dict_trie);
        dfs(board, i, j + 1, new_prefix, dict_trie);
        dfs(board, i, j - 1, new_prefix, dict_trie);

        // Reset to be unvisited
        board[i][j] = current_character;

        //********** What do I return at the bottom...?
        return "";
    }
}
