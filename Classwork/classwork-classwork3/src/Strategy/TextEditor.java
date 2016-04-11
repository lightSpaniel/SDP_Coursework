package Strategy;

public class TextEditor {

    private TextFormatter textFormatter;
    private String text;

    public TextEditor(TextFormatter textFormatter){

        this.textFormatter=textFormatter;
    }

    public void publishText(String text){

        String printText = textFormatter.format(text);
        System.out.println(printText);
    }
}
