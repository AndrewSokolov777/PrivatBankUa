package exp.privatebank.storage;

import java.util.List;

import exp.privatebank.model.BankDevice;
import exp.privatebank.pojo.DevicesPOJO.Device;
import exp.privatebank.pojo.RoutePojo.Route_;

public class DevicesStorage {

    private static List<Device> sAllDevices;
    private static List<BankDevice> sBankDevices;
    private static List<Route_> sRouteList;

    public static List<Device> getAllDevices() {
        return sAllDevices;
    }

    public static void setAllDevices(List<Device> sAllDevices) {
        DevicesStorage.sAllDevices = sAllDevices;
    }

    public static List<BankDevice> getBankDevices() {
        return sBankDevices;
    }

    public static void setBankDevices(List<BankDevice> sBankDevices) {
        DevicesStorage.sBankDevices = sBankDevices;
    }

    public static List<Route_> getRouteList() {
        return sRouteList;
    }

    public static void setRouteList(List<Route_> sRouteList) {
        DevicesStorage.sRouteList = sRouteList;
    }

    public static void nullAll() {
        sBankDevices = null;
        sRouteList = null;
        sAllDevices = null;
    }
}
