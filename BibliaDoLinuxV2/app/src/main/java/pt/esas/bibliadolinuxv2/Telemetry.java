package pt.esas.bibliadolinuxv2;

public class Telemetry {
    String id;
    String model;
    String androidVersion;
    String time;
    String date;

    public Telemetry(String id, String model, String androidVersion, String time, String date) {
        this.id = id;
        this.model = model;
        this.androidVersion = androidVersion;
        this.time = time;
        this.date = date;
    }

    public Telemetry() {

    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public String getDatenow() {
        return time;
    }

    public String getDate() {return date;}
}
