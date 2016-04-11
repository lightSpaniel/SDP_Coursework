package Strategy;

public class CapTextFormatter implements TextFormatter {

    public String format(String text){

        return "[" + this.getClass().getSimpleName() + "]" + " : " + text.toUpperCase();
    }
}
