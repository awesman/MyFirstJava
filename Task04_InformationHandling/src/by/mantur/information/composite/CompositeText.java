package by.mantur.information.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements IPart{
	
	private List<IPart> parts = new ArrayList<>();
    private TextPart level;

    public void setLevel(TextPart level) {
        this.level = level;
    }

    @Override
    public void add(IPart component) {
    	parts.add(component);
    }

    public void remove(IPart component) {
    	parts.remove(component);
    }

    @Override
    public String receiveText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IPart component : parts) {
            stringBuilder.append(component.receiveText());
        }
        return stringBuilder.toString();
    }

    @Override
    public List<IPart> receiveParts() {
        List<IPart> LowerComponents = new ArrayList<>();
        for (IPart part : parts) {
            LowerComponents.add(part);
            if (part.hasParts()) {
                LowerComponents.addAll(part.receiveParts());
            }
        }
        return LowerComponents;
    }

    @Override
    public boolean hasParts() {
        return parts.size() > 0;
    }

    @Override
    public TextPart level() {
        return level;
    }

    public List<IPart> receiveComponents(TextPart level) {
        List<IPart> allComponents = receiveParts();
        List<IPart> result = new ArrayList<>();
        for (IPart component : allComponents) {
            if (component.level() != null && component.level().equals(level)) {
                result.add(component);
            }
        }
        return result;
    }

    @Override
    public void removeParts() {
    	parts.clear();
    }

}
