public class Trie_Node {
    private static final int radix = 256;
    private boolean isWord;
    private Trie_Node[] next;

    // Constructor
    public Trie_Node() {
        isWord = false;
        next = new Trie_Node[radix];
    }

    // Other Functions
    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Trie_Node[] getNext() {
        return next;
    }
}