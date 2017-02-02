package au.com.dius.tennis

class Players {
    private List<Player> players = []

    Players(String player1Name, String player2Name) {
        players << new Player(player1Name)
        players << new Player(player2Name)
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
        players.first().points >= points && players.last().points >= points
    }

    boolean bothPlayersHaveMininumScoreForDeuce() {
        bothPlayersHaveScoredMoreThanOrEqualsToPoints(3)
    }

    boolean areInDeuce() {
        bothPlayersHaveMininumScoreForDeuce() && players.first().points == players.last().points
    }

    Map<String, Integer> asMap() {
        [
                (players.first().name): players.first().points,
                (players.last().name): players.last().points
        ]
    }

    String withPlayersPoints(Closure c) {
        c(players.first().points, players.last().points)
    }
}
