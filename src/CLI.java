import java.net.URI;
import java.net.URISyntaxException;

public class CLI {
    public static void main(String[] args) {
        String roombaHost = System.getProperty("roomba-host");
        String channel = System.getProperty("channel");

        System.out.println("Using roomba host: " + roombaHost);
        System.out.println("Using channel: " + channel);

        try {
            URI uri = new URI("ws://" + roombaHost + "/socket/websocket?vsn=1.0.0");
            Roombot roombot = new Roombot(uri, channel);

            System.out.println("Initializing connection.");
            roombot.connect();

            System.out.println("Setting up heartbeat back to host.");
            roombot.setupHeartbeat();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
