package examples.patterns.behavior.iterator;

import lombok.Getter;

@Getter
public class HockeyPlayer implements Iterable {
    private final String name;
    private final String[] awards;

    public HockeyPlayer(String name, String[] awards) {
        this.name = name;
        this.awards = awards;
    }

    @Override
    public Iterator getIterator() {
        return new AwardsIterator();
    }

    /**
     * Паттерн Iterator
     */
    private class AwardsIterator implements Iterator {
        private int i;

        @Override
        public boolean hasNext() {
            return i < awards.length;
        }

        @Override
        public Object next() {
            return awards[i++];
        }
    }
}
