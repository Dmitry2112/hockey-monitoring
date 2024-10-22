package examples.patterns.structure.composite;

import java.util.stream.Stream;

public interface HockeyStructureElement {
    void registerOnGame();
    void addHockeyStructureElement(HockeyStructureElement element);
    Stream<HockeyStructureElement> hockeyStructureElements();
}
