package Strategy;

public class LowerTextFormatter implements TextFormatter{

    public String format(String text){
        return "[" + this.getClass().getSimpleName() + "]" + " : " + text.toLowerCase();
    }
}
