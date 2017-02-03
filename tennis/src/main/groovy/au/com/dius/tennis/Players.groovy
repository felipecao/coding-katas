package au.com.dius.tennis

import static java.lang.Math.abs

class Players {

    private static final int MINIMUM_POINTS_FOR_DEUCE = 3

    private List<Player> players = []

    Players(String player1Name, String player2Name) {
        this(new Player(player1Name), new Player(player2Name))
    }

    protected Players(Player player1, Player player2) {
        players << player1
        players << player2
    }

    private Player findByName(String playerName) {
        players.find {it.name == playerName}
    }

    void pointWonByPlayerWithName(String playerName) {
        findByName(playerName).score()
    }

    boolean playerWithNameHasPoints(String playerName, Integer points) {
        findByName(playerName).points == points
    }

    boolean bothPlayersHaveScoredMoreThanOrEqualsToPoints(Integer points) {
        player1().points >= points && player2().points >= points
    }

    private Player player1() {
        players.first()
    }

    private Player player2() {
        players.last()
    }

    boolean anyPlayerHasScoredMoreThanOrEqualsToPoints(Integer points) {
        player1().points >= points || player2().points >= points
    }

    boolean bothPlayersHaveMininumScoreForDeuce() {
        bothPlayersHaveScoredMoreThanOrEqualsToPoints(MINIMUM_POINTS_FOR_DEUCE)
    }

    boolean areInDeuce() {
        bothPlayersHaveMininumScoreForDeuce() && player1().points == player2().points
    }

    boolean differenceInPointsIs(Integer points) {
        points == abs(player1().points - player2().points)
    }

    boolean differenceInPointsIsGreaterThanOrEqualsTo(Integer points) {
        abs(player1().points - player2().points) >= points
    }

    String withPlayersPoints(Closure c) {
        c(player1().points, player2().points)
    }

    String withAdvantagePlayerName(Closure c) {
        c(player1().points - player2().points > 0 ? player1().name : player2().name)
    }
}
