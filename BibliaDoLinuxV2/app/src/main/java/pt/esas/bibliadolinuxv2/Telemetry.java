package pt.esas.bibliadolinuxv2;

public class Telemetry {
    String model;
    String androidVersion;
    String time;
    String date;

    public Telemetry(String model, String androidVersion, String time, String date) {
        this.model = model;
        this.androidVersion = androidVersion;
        this.time = time;
        this.date = date;
    }

    public Telemetry() {

    }

    public String getModel() {
        return model;
    }

     public String getAndroidVersion() {
        return androidVersion;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {return date;}
}
