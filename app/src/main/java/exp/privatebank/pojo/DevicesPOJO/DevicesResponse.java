
package exp.privatebank.pojo.DevicesPOJO;

import android.os.Parcelable;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DevicesResponse implements Parcelable
{

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("devices")
    @Expose
    private List<Device> devices = null;
    public final static Creator<DevicesResponse> CREATOR = new Creator<DevicesResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DevicesResponse createFromParcel(Parcel in) {
            DevicesResponse instance = new DevicesResponse();
            instance.city = ((String) in.readValue((String.class.getClassLoader())));
            instance.address = ((String) in.readValue((String.class.getClassLoader())));
            instance.devices = in.readArrayList(Device.class.getClassLoader());
            return instance;
        }

        public DevicesResponse[] newArray(int size) {
            return (new DevicesResponse[size]);
        }

    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(city);
        dest.writeValue(address);
        dest.writeList(devices);
    }

    public int describeContents() {
        return  0;
    }
}
