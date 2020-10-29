package my.playground;

public class Player {
    private String name;
    private Hand hand;

    public Player(String playerName, Hand hand) {
        this.name = playerName;
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
