package examples.patterns.structure.composite;

import java.util.stream.Stream;

public class HockeyPlayer implements HockeyStructureElement {
    @Override
    public void registerOnGame() {
        System.out.println("Регистрация на игру выполнена!");
    }

    @Override
    public void addHockeyStructureElement(HockeyStructureElement element) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Stream<HockeyStructureElement> hockeyStructureElements() {
        return Stream.empty();
    }
}
