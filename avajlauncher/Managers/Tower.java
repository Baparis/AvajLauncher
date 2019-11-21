package avajlauncher.Managers;

import avajlauncher.Flyable;
import avajlauncher.Flyable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stari
 */
public class Tower {

    static private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable)) {
            return;
        }
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        int i = 0;

        while (i < observers.size()) {
            observers.get(i++).updateConditions();
        }
    }
}
