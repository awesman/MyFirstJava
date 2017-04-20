package by.mantur.information.composite;

import java.util.List;

public interface IPart {
	
	String receiveText();

    default List<IPart> receiveParts() {
        throw new UnsupportedOperationException();
    }


    default boolean hasParts() {
        return false;
    }

    TextPart level();

    default List<IPart> receiveComponents(TextPart level) {
        throw new UnsupportedOperationException();
    }

    default void removeParts() {
        throw new UnsupportedOperationException();
    }

    default void add(IPart component) {
        throw new UnsupportedOperationException();
    }

}
