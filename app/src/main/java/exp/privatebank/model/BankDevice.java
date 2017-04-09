package exp.privatebank.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class BankDevice {

    @Id(autoincrement = true)
    Long id;

    String type;

    String cityEn;
    String cityRu;
    String cityUa;

    String addressEn;
    String addressRu;
    String addressUa;

    String placeRu;
    String placeUa;

    String latitude;
    String longitude;
    @Generated(hash = 917671324)
    public BankDevice(Long id, String type, String cityEn, String cityRu,
            String cityUa, String addressEn, String addressRu, String addressUa,
            String placeRu, String placeUa, String latitude, String longitude) {
        this.id = id;
        this.type = type;
        this.cityEn = cityEn;
        this.cityRu = cityRu;
        this.cityUa = cityUa;
        this.addressEn = addressEn;
        this.addressRu = addressRu;
        this.addressUa = addressUa;
        this.placeRu = placeRu;
        this.placeUa = placeUa;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    @Generated(hash = 1298310047)
    public BankDevice() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCityEn() {
        return this.cityEn;
    }
    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }
    public String getCityRu() {
        return this.cityRu;
    }
    public void setCityRu(String cityRu) {
        this.cityRu = cityRu;
    }
    public String getCityUa() {
        return this.cityUa;
    }
    public void setCityUa(String cityUa) {
        this.cityUa = cityUa;
    }
    public String getAddressEn() {
        return this.addressEn;
    }
    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }
    public String getAddressRu() {
        return this.addressRu;
    }
    public void setAddressRu(String addressRu) {
        this.addressRu = addressRu;
    }
    public String getAddressUa() {
        return this.addressUa;
    }
    public void setAddressUa(String addressUa) {
        this.addressUa = addressUa;
    }
    public String getPlaceRu() {
        return this.placeRu;
    }
    public void setPlaceRu(String placeRu) {
        this.placeRu = placeRu;
    }
    public String getPlaceUa() {
        return this.placeUa;
    }
    public void setPlaceUa(String placeUa) {
        this.placeUa = placeUa;
    }
    public String getLatitude() {
        return this.latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return this.longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
