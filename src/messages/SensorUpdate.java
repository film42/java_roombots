package messages;

import org.json.JSONException;
import org.json.JSONObject;

public class SensorUpdate {
    private int lightBumperRightFront;
    private int lightBumperRightCenter;
    private int lightBumperRight;
    private int lightBumperLeftFront;
    private int lightBumperLeftCenter;
    private int lightBumperLeft;
    private int bumperRight;
    private int bumperLeft;

    private JSONObject payload;

    public SensorUpdate(JSONObject payload) {
        try {
            this.lightBumperRightFront = payload.getInt("light_bumper_right_front");
            this.lightBumperRightCenter = payload.getInt("light_bumper_right_center");
            this.lightBumperRight = payload.getInt("light_bumper_right");
            this.lightBumperLeftFront = payload.getInt("light_bumper_left_front");
            this.lightBumperLeftCenter = payload.getInt("light_bumper_left_center");
            this.lightBumperLeft = payload.getInt("light_bumper_left");
            this.bumperRight = payload.getInt("bumper_right");
            this.bumperLeft = payload.getInt("bumper_left");

            this.payload = payload;
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public int getLightBumperRightFront() {
        return lightBumperRightFront;
    }

    public int getLightBumperRightCenter() {
        return lightBumperRightCenter;
    }

    public int getLightBumperRight() {
        return lightBumperRight;
    }

    public int getLightBumperLeftFront() {
        return lightBumperLeftFront;
    }

    public int getLightBumperLeftCenter() {
        return lightBumperLeftCenter;
    }

    public int getLightBumperLeft() {
        return lightBumperLeft;
    }

    public int getBumperRight() {
        return bumperRight;
    }

    public int getBumperLeft() {
        return bumperLeft;
    }

    public String toString() {
        return payload.toString();
    }
}
