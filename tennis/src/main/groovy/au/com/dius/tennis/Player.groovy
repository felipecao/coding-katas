package au.com.dius.tennis

class Player {

    private static final Integer INITIAL_POINTS = 0

    private final String name
    private Integer points = INITIAL_POINTS

    Player(String name) {
        this.name = name
    }

    protected Player(String name, Integer points) {
        this.name = name
        this.points = points
    }

    Integer getPoints() {
        return points
    }

    String getName() {
        return name
    }

    void score() {
        points++
    }
}
