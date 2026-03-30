package ra.edu;

interface Connectable {
    void connectWifi();
}
interface Chargeable {
    void charge();
}
abstract class Device {
    protected int id;
    protected String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void turnOn();
    abstract void turnOff();

    public String getName() {
        return name;
    }
}

class SmartPhone extends Device implements Connectable, Chargeable {
    public SmartPhone(int id, String name) { super(id, name); }

    @Override
    void turnOn() { System.out.println(name + " đang khởi động (Smartphone)"); }
    @Override
    void turnOff() { System.out.println(name + " đang tắt nguồn"); }
    @Override
    public void connectWifi() { System.out.println(name + " đã kết nối Wifi"); }
    @Override
    public void charge() { System.out.println(name + " đang sạc pin"); }
}

class Laptop extends Device implements Connectable, Chargeable {
    public Laptop(int id, String name) { super(id, name); }

    @Override
    void turnOn() { System.out.println(name + " đang mở máy (Laptop)"); }
    @Override
    void turnOff() { System.out.println(name + " đang Shutdown"); }
    @Override
    public void connectWifi() { System.out.println(name + " đã kết nối mạng nội bộ"); }
    @Override
    public void charge() { System.out.println(name + " đang cắm sạc Adapter"); }
}

class Television extends Device implements Connectable {
    public Television(int id, String name) { super(id, name); }

    @Override
    void turnOn() { System.out.println(name + " đang bật màn hình (TV)."); }
    @Override
    void turnOff() { System.out.println(name + " đang tắt (Standby)."); }
    @Override
    public void connectWifi() { System.out.println(name + " đã kết nối Smart TV Wifi."); }
}

public class Ex11_4 {
    public static void main(String[] args) {

        Device[] devices = {
                new SmartPhone(1, "Samsung Galaxy S24"),
                new Laptop(2, "MacBook Pro M3"),
                new Television(3, "LG OLED TV")
        };

        System.out.println("Quản lí thiết bị điện tử");

        for (Device d : devices) {
            System.out.println("\n Xử lý: " + d.getName() + " ");

            d.turnOn();

            if (d instanceof Connectable) {
                ((Connectable) d).connectWifi();
            }

            if (d instanceof Chargeable) {
                ((Chargeable) d).charge();
            }
            d.turnOff();
        }
    }
}