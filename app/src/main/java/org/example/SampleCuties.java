package org.example;

public class SampleCuties {
    public static Cutie createPuppy() {
        return new Cutie() {
            public String description() { return "Fluffy puppy with big eyes"; }
            public Integer cutenessRating() { return 10; }
        };
    }

    public static Cutie createKitten() {
        return new Cutie() {
            public String description() { return "Tiny kitten playing with yarn"; }
            public Integer cutenessRating() { return 9; }
        };
    }

    public static Cutie createBabyPanda() {
        return new Cutie() {
            public String description() { return "Baby panda rolling around"; }
            public Integer cutenessRating() { return 11; }
        };
    }

    public static Cutie createDuckling() {
        return new Cutie() {
            public String description() { return "Little yellow duckling"; }
            public Integer cutenessRating() { return 8; }
        };
    }
}
