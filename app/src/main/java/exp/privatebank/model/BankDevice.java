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

    String mon;
    String tue;
    String wed;
    String thu;
    String fri;
    String sat;
    String sun;

    @Generated(hash = 1711423308)
    public BankDevice(Long id, String type, String cityEn, String cityRu,
            String cityUa, String addressEn, String addressRu, String addressUa,
            String placeRu, String placeUa, String latitude, String longitude,
            String mon, String tue, String wed, String thu, String fri, String sat,
            String sun) {
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
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
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
    public String getMon() {
        return this.mon;
    }
    public void setMon(String mon) {
        this.mon = mon;
    }
    public String getTue() {
        return this.tue;
    }
    public void setTue(String tue) {
        this.tue = tue;
    }
    public String getWed() {
        return this.wed;
    }
    public void setWed(String wed) {
        this.wed = wed;
    }
    public String getThu() {
        return this.thu;
    }
    public void setThu(String thu) {
        this.thu = thu;
    }
    public String getFri() {
        return this.fri;
    }
    public void setFri(String fri) {
        this.fri = fri;
    }
    public String getSat() {
        return this.sat;
    }
    public void setSat(String sat) {
        this.sat = sat;
    }
    public String getSun() {
        return this.sun;
    }
    public void setSun(String sun) {
        this.sun = sun;
    }
}
