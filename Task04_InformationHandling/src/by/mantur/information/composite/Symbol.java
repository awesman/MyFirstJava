package by.mantur.information.composite;

public class Symbol implements IPart {
	
	private String content;

    public Symbol(String content) {
        this.content = content;
    }

    @Override
    public String receiveText() {
        return content;
    }

    @Override
    public TextPart level() {
        return TextPart.SYMBOL;
    }

}
