
package exp.privatebank.pojo.DevicesPOJO;

import android.os.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tw implements Parcelable
{

    @SerializedName("mon")
    @Expose
    private String mon;
    @SerializedName("tue")
    @Expose
    private String tue;
    @SerializedName("wed")
    @Expose
    private String wed;
    @SerializedName("thu")
    @Expose
    private String thu;
    @SerializedName("fri")
    @Expose
    private String fri;
    @SerializedName("sat")
    @Expose
    private String sat;
    @SerializedName("sun")
    @Expose
    private String sun;
    @SerializedName("hol")
    @Expose
    private String hol;
    public final static Creator<Tw> CREATOR = new Creator<Tw>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Tw createFromParcel(Parcel in) {
            Tw instance = new Tw();
            instance.mon = ((String) in.readValue((String.class.getClassLoader())));
            instance.tue = ((String) in.readValue((String.class.getClassLoader())));
            instance.wed = ((String) in.readValue((String.class.getClassLoader())));
            instance.thu = ((String) in.readValue((String.class.getClassLoader())));
            instance.fri = ((String) in.readValue((String.class.getClassLoader())));
            instance.sat = ((String) in.readValue((String.class.getClassLoader())));
            instance.sun = ((String) in.readValue((String.class.getClassLoader())));
            instance.hol = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Tw[] newArray(int size) {
            return (new Tw[size]);
        }

    }
    ;

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getHol() {
        return hol;
    }

    public void setHol(String hol) {
        this.hol = hol;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mon);
        dest.writeValue(tue);
        dest.writeValue(wed);
        dest.writeValue(thu);
        dest.writeValue(fri);
        dest.writeValue(sat);
        dest.writeValue(sun);
        dest.writeValue(hol);
    }

    public int describeContents() {
        return  0;
    }

}
