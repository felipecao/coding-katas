package au.com.dius.tennis

class Players {
    private List<Player> players = []

    Players(String player1Name, String player2Name) {
        players << new Player(player1Name)
        players << new Player(player2Name)
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

    Map<String, Integer> asMap() {
        [
                (players.first().name): players.first().points,
                (players.last().name): players.last().points
        ]
    }
}
