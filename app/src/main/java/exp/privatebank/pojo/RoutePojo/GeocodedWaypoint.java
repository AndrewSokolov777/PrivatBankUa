
package exp.privatebank.pojo.RoutePojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeocodedWaypoint {

    private String geocoderStatus;
    private String placeId;
    private List<String> types = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getGeocoderStatus() {
        return geocoderStatus;
    }

    public void setGeocoderStatus(String geocoderStatus) {
        this.geocoderStatus = geocoderStatus;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
