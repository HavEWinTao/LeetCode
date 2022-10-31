import java.util.Map;

public class TextEditor {
    private int cursor;
    private StringBuilder sb;

    public TextEditor() {
        cursor = 0;
        sb = new StringBuilder();
    }

    public void addText(String text) {
        int length = text.length();
        sb.insert(cursor, text);
        cursor += length;
    }

    public int deleteText(int k) {
        int leftBound = Math.max(0, cursor - k);
        sb.replace(leftBound, cursor, "");
        int deleteLength = leftBound == 0 ? cursor : k;
        cursor = leftBound;
        return deleteLength;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        int index = Math.min(cursor, 10);
        return sb.substring(cursor - index, cursor);
    }

    public String cursorRight(int k) {
        int length = sb.length();
        cursor = Math.min(length, cursor + k);
        int index = Math.min(cursor, 10);
        return sb.substring(cursor - index, cursor);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorLeft(2));
        System.out.println(textEditor.cursorRight(6));
        System.out.println("暂停");
    }
}
