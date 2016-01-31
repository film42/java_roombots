import messages.DriveCommand;
import messages.HeartbeatCommand;
import messages.JoinCommand;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class Driver extends WebSocketClient {
    private String channel;

    public Driver(URI serverURI, String channel) {
        super(serverURI);

        this.channel = channel;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        joinChannel();
    }

    @Override
    public void onMessage(String s) {
        System.out.println("Received message: " + s);

        try {
            JSONObject jsonObject = new JSONObject(s);

            if(jsonObject.has("event") && jsonObject.getString("event").equals("phx_reply")) {
                if(jsonObject.has("ref") && jsonObject.getInt("ref") == 1) {
                    System.out.println("Successfully joined the channel: " + this.channel);

                    // Send a start event to our roombot.
                    onStart();
                }
            }

            onJsonMessage(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("A close message was received: " + s);
        System.exit(0);
    }

    @Override
    public void onError(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        System.exit(-1);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending message: " + message);
        super.send(message);
    }

    public void joinChannel() {
        JoinCommand joinCommand = new JoinCommand(channel);
        this.send(joinCommand.toJson());
    }

    public void onStart() {
        System.out.println("This should be implemented by you!");
    }

    public void onJsonMessage(JSONObject jsonObject) throws JSONException {
        if(jsonObject.has("topic") && jsonObject.getString("topic").equals(this.channel)) {
            onChannelMessage(jsonObject);
        }
    }

    public void onChannelMessage(JSONObject jsonObject) throws JSONException {
        System.out.println("This should be implemented by you!");
    }

    public void drive(int velocity, int radius) {
        DriveCommand driveCommand = new DriveCommand(this.channel, velocity, radius);
        this.send(driveCommand.toJson());
    }

    public void setupHeartbeat() {
        HeartbeatCommand heartbeatCommand = new HeartbeatCommand();

        while(true) {
            try {
                Thread.sleep(1000);
                this.send(heartbeatCommand.toJson());
            } catch (InterruptedException e) {
                System.out.println("Hearbeat failed!");
                e.printStackTrace();
            }
        }
    }
}
