package examples.patterns.behavior.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final List<Observer> hockeyFans = new ArrayList<>();

    @Getter
    private int blueGoals = 0;

    @Getter
    private int redGoals = 0;

    public void subscribe(Observer o) {
        if (o != null) {
            hockeyFans.add(o);
        }
    }

    public void unsubscribe(Observer o) {
        hockeyFans.remove(o);
    }

    public void notifyObservers() {
        hockeyFans.forEach(o -> o.update(this));
    }

    public void increaseBlueGoals() {
        blueGoals++;
        notifyObservers();
    }

    public void increaseRedGoals() {
        redGoals++;
        notifyObservers();
    }
}
