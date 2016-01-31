package messages;

public class JoinCommand {
    private String channel;

    public JoinCommand(String channel) {
        this.channel = channel;
    }

    public String toJson() {
        return String.format("{ \"ref\" : 1, \"event\" : \"phx_join\", \"payload\" : {}, \"topic\" : \"%s\" }", this.channel);
    }
}
