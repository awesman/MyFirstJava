package by.mantur.information.operator;


import java.util.Iterator;
import java.util.List;

import by.mantur.information.composite.TextPart;
import by.mantur.information.composite.IPart;
import by.mantur.information.interpreter.Context;
import by.mantur.information.interpreter.Interpreter;

public class TextOperator {
	
	public void calculateText(IPart text, Interpreter interpreter, Context context) {
        receiveMathExpressions(text).forEach((IPart component) -> {
            String expression = component.receiveText().trim();
            List<String> rpnList = ExpressionOperator.receiveRpnList(expression);
            IPart result = interpreter.executeInterpretation(rpnList, context);
            component.removeParts();
            component.add(result);
            context.resetContext();
        });
    }

    public void swapFirstLastLexeme(IPart text) {
        List<IPart> sentences = text.receiveComponents(TextPart.SENTENCE);
        sentences.forEach((IPart component) -> {
            List<IPart> lexemes = component.receiveComponents(TextPart.LEXEME);
            IPart temp = lexemes.get(0);
            IPart last = lexemes.get(lexemes.size() - 1);
            lexemes.set(0, last);
            lexemes.set(lexemes.size() - 1, temp);
            component.removeParts();
            lexemes.forEach(component::add);
        });
    }

    public void removeLexemes(IPart text, char firstCharacter, int length) {
        List<IPart> components = text.receiveParts();
        Iterator<IPart> iterator = components.iterator();
        int minOrdinal = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            IPart component = iterator.next();
            if (component.level().ordinal() < minOrdinal) {
                minOrdinal = component.level().ordinal();
            }
            if (component.level().equals(TextPart.LEXEME)) {
                String lexemeText = component.receiveText();
                if (lexemeText.charAt(0) == firstCharacter && lexemeText.length() == length) {
                    component.removeParts();
                }
            }
        }
        text.removeParts();
        for (IPart component : components) {
            if (component.level().ordinal() == minOrdinal) {
                text.add(component);
            }
        }
    }

    public List<IPart> sentencesMinToMaxLexemes(IPart text) {
        List<IPart> sentences = text.receiveComponents(TextPart.SENTENCE);
        sentences.sort((o1, o2) -> {
            int o1Size = o1.receiveComponents(TextPart.LEXEME).size();
            int o2Size = o2.receiveComponents(TextPart.LEXEME).size();
            return o1Size > o2Size ? 1 : o1Size == o2Size ? 0 : -1;
        });
        return sentences;
    }

    private List<IPart> receiveMathExpressions(IPart text) {
        return text.receiveComponents(TextPart.MATH);
    }

}
