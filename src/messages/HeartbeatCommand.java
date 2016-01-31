package messages;

public class HeartbeatCommand {
    public String toJson() {
        return "{ \"topic\" : \"phoenix\", \"event\" : \"heartbeat\", \"payload\": {}, \"ref\": 10 }";
    }
}
