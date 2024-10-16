package examples.patterns.structure.bridge;

import java.util.Random;

public class Usage {
    public static void main(String[] args) {
        Random random = new Random();
        MatchLevel matchLevel = random.nextBoolean() ? MatchLevel.City : MatchLevel.Region;

        Judge chiefJudge;
        Judge videoJudge;

        if (matchLevel == MatchLevel.City) {
            chiefJudge = new ChiefJudge(new CityJudge());
            videoJudge = new VideoJudge(new CityJudge());
        } else {
            chiefJudge = new ChiefJudge(new RegionJudge());
            videoJudge = new VideoJudge(new RegionJudge());
        }

        System.out.println(chiefJudge.getVerdict());
        System.out.println(videoJudge.getVerdict());
    }

    enum MatchLevel {
        City,
        Region
    }
}
