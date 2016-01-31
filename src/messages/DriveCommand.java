package messages;

/**
 * Created by garrettthornburg on 1/30/16.
 */
public class DriveCommand {
    private String channel;
    private int velocity;
    private int radius;

    public DriveCommand(String channel, int velocity, int radius) {
        this.channel = channel;
        this.velocity = velocity;
        this.radius = radius;
    }

    public String toJson() {
        String payload = String.format("{ \"velocity\" : %d, \"radius\" : %d }", this.velocity, this.radius);
        return String.format("{ \"topic\" : \"%s\", \"event\" : \"drive\", \"ref\" : 15, \"payload\" : %s }", this.channel, payload);
    }
}
