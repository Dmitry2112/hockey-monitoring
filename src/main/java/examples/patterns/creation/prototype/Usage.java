package examples.patterns.creation.prototype;

import java.util.List;

public class Usage {
    public static void main(String[] args) {
        HockeyPlayer player = new HockeyPlayer("Дима", 12);

        System.out.println(player.copy().say());
        System.out.println(player.copy().say());
        System.out.println(player.copy().say());

        Trainer trainer = new Trainer(
                "Иван Иванович",
                55,
                List.of((HockeyPlayer)player.copy(), (HockeyPlayer)player.copy(), (HockeyPlayer)player.copy())
        );

        trainer.printTeam();
    }
}
