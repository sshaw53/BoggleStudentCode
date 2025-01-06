public class TST {
    private TST_Node root = new TST_Node();

    public void insert(String s) {
        // For each letter in string s
        TST_Node current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current.getCharacter() == '-') {
                current.setCharacter(s.charAt(i));
            }
            // If it's equivalent to the letter in the root, continue down to the next node
            // While we haven't found the letter it's equivalent to, traverse left and right based on if it's
            // less than or more than that character
            while (s.charAt(i) != current.getCharacter()) {
                // If the character is smaller than the current value, go to the left
                if (s.charAt(i) < current.getCharacter()) {
                    // If the node to the left is null, create a node with this letter value and set current to this
                    // node
                    if (current.getLeft() == null) {
                        current.setLeft(new TST_Node());
                        current.getLeft().setCharacter(s.charAt(i));
                    }
                    // Either way, continue to traverse down the Trie
                    current = current.getLeft();
                }
                // Repeat for if greater than the character value
                else {
                    if (current.getRight() == null) {
                        current.setRight(new TST_Node());
                        current.getRight().setCharacter(s.charAt(i));
                    }
                    current = current.getRight();
                }
            }
            // By now, we know that the current node is at the String's character to then go down to the center node
            // If the next node is null, create a new node
            if (current.getCenter() == null) {
                current.setCenter(new TST_Node());
            }
            // Set current to equal that node
            current = current.getCenter();
        }
        // Once we've reached the end of the word, set the last node as true for isWord
        current.setWord(true);
    }
    public boolean lookup(String s) {
        TST_Node current = root;
        // For every letter in the String s
        for (int i = 0; i < s.length(); i++) {
            // While we haven't reached the current letter, keep looking
            while (current.getCharacter() != s.charAt(i)) {
                // If the branch doesn't exist (there is no Node to go to next), the word isn't in the Trie (return false)
                if (s.charAt(i) < current.getCharacter() && current.getLeft() == null) {
                    return false;
                }
                if (s.charAt(i) > current.getCharacter() && current.getRight() == null) {
                    return false;
                }
                // Follow to the next node in the tree based on the next letter of the word
                if (s.charAt(i) < current.getCharacter()) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            // Once we know the word is equal, if the next letter is null, return false. If not, go down to the center
            // node and keep traversing through the word.
            if (current.getCharacter() == s.charAt(i) && current.getCenter() == null) {
                return false;
            }
            else {
                current = current.getCenter();
            }
        }

        // If we reach the end of the word and isWord is false, return false
        if (!current.isWord()) {
            return false;
        }
        // Otherwise, we found the word (set isWord to false so that we avoid repeats, then return true)
        current.setWord(false);
        return true;
    }

}
