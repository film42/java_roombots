import messages.SensorUpdate;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class Roombot extends Driver {
    public Roombot(URI serverURI, String channel) {
        super(serverURI, channel);
    }

    // This helper method is here to help you parse the sensor update message. This essentially wraps the
    // message in a simple class. This message is only sent by a roomba when one of its sensor's change.
    public void onSensorUpdate(SensorUpdate sensorUpdate) {
        System.out.println("Received a sensor update message!: " + sensorUpdate.toString());

        if(sensorUpdate.getLightBumperLeftCenter() == 1 || sensorUpdate.getLightBumperRightCenter() == 1) {
            this.drive(100, 1);
        }
    }

    // Once connected to the roomba, this method is called every time a message is received from the channel
    // specified on startup. This method is essentially a fire hose callback. You'll find that this method
    // can become very noisy. You might want to use this method to route specific events like sense updates.
    @Override
    public void onChannelMessage(JSONObject jsonObject) throws JSONException {
        if(jsonObject.has("event") && jsonObject.getString("event").equals("sensor_update")) {
           SensorUpdate sensorUpdate = new SensorUpdate(jsonObject.getJSONObject("payload"));
            onSensorUpdate(sensorUpdate);
        }
    }

    // This method is called right after we connect to the channel. This is essentially an onChannelMessage
    // that is only every called once. This might help you setup a few things, but you might also find that
    // you don't need this helper method.
    @Override
    public void onStart() {
        this.drive(500, 0);
    }
}
