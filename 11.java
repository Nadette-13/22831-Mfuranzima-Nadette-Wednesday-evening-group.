// Controllable Interface
interface Controllable {
    void turnOn();
    void turnOff();
}

// Programmable Interface
interface Programmable {
    void scheduleTurnOn();
    void scheduleTurnOff();
}

// Abstract SmartDevice Class
abstract class SmartDevice {
    private String deviceName;
    private String status;
    private double energyConsumption;

    // Constructor
    public SmartDevice(String deviceName, String status, double energyConsumption) {
        this.deviceName = deviceName;
        this.status = status;
        this.energyConsumption = energyConsumption;
    }

    // Getters
    public String getDeviceName() {
        return deviceName;
    }

    public String getStatus() {
        return status;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    // Abstract method to display device details
    public abstract void displayDeviceDetails();
}

// Light Class
class Light extends SmartDevice implements Controllable, Programmable {
    public Light(String deviceName, String status, double energyConsumption) {
        super(deviceName, status, energyConsumption);
    }

    @Override
    public void turnOn() {
        System.out.println(getDeviceName() + " is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println(getDeviceName() + " is now OFF.");
    }

    @Override
    public void scheduleTurnOn() {
        System.out.println("Scheduling " + getDeviceName() + " to turn ON.");
    }

    @Override
    public void scheduleTurnOff() {
        System.out.println("Scheduling " + getDeviceName() + " to turn OFF.");
    }

    @Override
    public void displayDeviceDetails() {
        System.out.println("Light: " + getDeviceName() + " | Status: " + getStatus());
    }
}

// Thermostat Class
class Thermostat extends SmartDevice implements Controllable, Programmable {
    public Thermostat(String deviceName, String status, double energyConsumption) {
        super(deviceName, status, energyConsumption);
    }

    @Override
    public void turnOn() {
        System.out.println(getDeviceName() + " is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println(getDeviceName() + " is now OFF.");
    }

    @Override
    public void scheduleTurnOn() {
        System.out.println("Scheduling " + getDeviceName() + " to turn ON.");
    }

    @Override
    public void scheduleTurnOff() {
        System.out.println("Scheduling " + getDeviceName() + " to turn OFF.");
    }

    @Override
    public void displayDeviceDetails() {
        System.out.println("Thermostat: " + getDeviceName() + " | Status: " + getStatus());
    }
}

// Camera Class
class Camera extends SmartDevice implements Controllable {
    public Camera(String deviceName, String status, double energyConsumption) {
        super(deviceName, status, energyConsumption);
    }

    @Override
    public void turnOn() {
        System.out.println(getDeviceName() + " is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println(getDeviceName() + " is now OFF.");
    }

    @Override
    public void displayDeviceDetails() {
        System.out.println("Camera: " + getDeviceName() + " | Status: " + getStatus());
    }
}

// Main class to test Smart Home System
public class SmartHome {
    public static void main(String[] args) {
        Light light = new Light("Living Room Light", "OFF", 10);
        light.displayDeviceDetails();
        light.turnOn();
        light.scheduleTurnOn();

        Thermostat thermostat = new Thermostat("Bedroom Thermostat", "OFF", 15);
        thermostat.displayDeviceDetails();
        thermostat.turnOn();
        thermostat.scheduleTurnOff();

        Camera camera = new Camera("Security Camera", "OFF", 30);
        camera.displayDeviceDetails();
        camera.turnOn();
    }
}
