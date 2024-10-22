package examples.patterns.structure.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Паттерн Composite
 */
public class HockeyTeam implements HockeyStructureElement {
    private final List<HockeyStructureElement> children = new ArrayList<>();

    @Override
    public void registerOnGame() {
        for (HockeyStructureElement child : children) {
            child.registerOnGame();
        }
    }

    @Override
    public void addHockeyStructureElement(HockeyStructureElement element) {
        if (element != null) {
            children.add(element);
        }
    }

    @Override
    public Stream<HockeyStructureElement> hockeyStructureElements() {
        return children.stream();
    }
}
