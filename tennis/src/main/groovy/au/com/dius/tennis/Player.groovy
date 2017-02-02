package au.com.dius.tennis

class Player {
    private String name
    private Integer points = 0

    Player(String name) {
        this.name = name
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
