package examples.patterns.behavior.iterator;

public class Usage {
    public static void main(String[] args) {
        String[] awards = {"Победитель городского турнира", "Победитель областного турнира", "Призер всероссийского турнира"};

        HockeyPlayer player = new HockeyPlayer("Дмитрий", awards);

        Iterator iterator = player.getIterator();

        System.out.printf("Игрок: %s%n", player.getName());
        System.out.println("Награды: ");

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
