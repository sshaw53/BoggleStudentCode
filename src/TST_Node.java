public class TST_Node {
    private char character;
    private boolean isWord;
    private TST_Node left;
    private TST_Node right;
    private TST_Node center;

    // Constructor
    public TST_Node() {
        isWord = false;
        left = null;
        right = null;
        center = null;
        character = '-';
    }

    // Other Functions (getters and setters)
    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
    public void setCharacter(char chara) {
        character = chara;
    }

    public void setCenter(TST_Node node) {
        center = node;
    }

    public void setRight(TST_Node node) {
        right = node;
    }

    public void setLeft(TST_Node node) {
        left = node;
    }

    public TST_Node getRight() {
        return right;
    }

    public TST_Node getLeft() {
        return left;
    }

    public TST_Node getCenter() {
        return center;
    }

    public char getCharacter() {
        return character;
    }
}