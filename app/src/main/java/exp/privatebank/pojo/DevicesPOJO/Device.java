
package exp.privatebank.pojo.DevicesPOJO;

import android.os.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("cityRU")
    @Expose
    private String cityRU;
    @SerializedName("cityUA")
    @Expose
    private String cityUA;
    @SerializedName("cityEN")
    @Expose
    private String cityEN;
    @SerializedName("fullAddressRu")
    @Expose
    private String fullAddressRu;
    @SerializedName("fullAddressUa")
    @Expose
    private String fullAddressUa;
    @SerializedName("fullAddressEn")
    @Expose
    private String fullAddressEn;
    @SerializedName("placeRu")
    @Expose
    private String placeRu;
    @SerializedName("placeUa")
    @Expose
    private String placeUa;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("tw")
    @Expose
    private Tw tw;
    public final static Creator<Device> CREATOR = new Creator<Device>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Device createFromParcel(Parcel in) {
            Device instance = new Device();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.cityRU = ((String) in.readValue((String.class.getClassLoader())));
            instance.cityUA = ((String) in.readValue((String.class.getClassLoader())));
            instance.cityEN = ((String) in.readValue((String.class.getClassLoader())));
            instance.fullAddressRu = ((String) in.readValue((String.class.getClassLoader())));
            instance.fullAddressUa = ((String) in.readValue((String.class.getClassLoader())));
            instance.fullAddressEn = ((String) in.readValue((String.class.getClassLoader())));
            instance.placeRu = ((String) in.readValue((String.class.getClassLoader())));
            instance.placeUa = ((String) in.readValue((String.class.getClassLoader())));
            instance.latitude = ((String) in.readValue((String.class.getClassLoader())));
            instance.longitude = ((String) in.readValue((String.class.getClassLoader())));
            instance.tw = ((Tw) in.readValue((Tw.class.getClassLoader())));
            return instance;
        }

        public Device[] newArray(int size) {
            return (new Device[size]);
        }

    };

    public Device() {
    }

    public Device(String type, String cityRU, String cityUA, String cityEN, String fullAddressRu,
                  String fullAddressUa, String fullAddressEn, String placeRu, String placeUa,
                  String latitude, String longitude, Tw tw) {
        this.type = type;
        this.cityRU = cityRU;
        this.cityUA = cityUA;
        this.cityEN = cityEN;
        this.fullAddressRu = fullAddressRu;
        this.fullAddressUa = fullAddressUa;
        this.fullAddressEn = fullAddressEn;
        this.placeRu = placeRu;
        this.placeUa = placeUa;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tw = tw;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCityRU() {
        return cityRU;
    }

    public void setCityRU(String cityRU) {
        this.cityRU = cityRU;
    }

    public String getCityUA() {
        return cityUA;
    }

    public void setCityUA(String cityUA) {
        this.cityUA = cityUA;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getFullAddressRu() {
        return fullAddressRu;
    }

    public void setFullAddressRu(String fullAddressRu) {
        this.fullAddressRu = fullAddressRu;
    }

    public String getFullAddressUa() {
        return fullAddressUa;
    }

    public void setFullAddressUa(String fullAddressUa) {
        this.fullAddressUa = fullAddressUa;
    }

    public String getFullAddressEn() {
        return fullAddressEn;
    }

    public void setFullAddressEn(String fullAddressEn) {
        this.fullAddressEn = fullAddressEn;
    }

    public String getPlaceRu() {
        return placeRu;
    }

    public void setPlaceRu(String placeRu) {
        this.placeRu = placeRu;
    }

    public String getPlaceUa() {
        return placeUa;
    }

    public void setPlaceUa(String placeUa) {
        this.placeUa = placeUa;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Tw getTw() {
        return tw;
    }

    public void setTw(Tw tw) {
        this.tw = tw;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(cityRU);
        dest.writeValue(cityUA);
        dest.writeValue(cityEN);
        dest.writeValue(fullAddressRu);
        dest.writeValue(fullAddressUa);
        dest.writeValue(fullAddressEn);
        dest.writeValue(placeRu);
        dest.writeValue(placeUa);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(tw);
    }

    public int describeContents() {
        return  0;
    }

}
