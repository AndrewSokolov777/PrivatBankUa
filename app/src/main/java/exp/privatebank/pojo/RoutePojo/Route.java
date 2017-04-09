
package exp.privatebank.pojo.RoutePojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Route {

    private List<GeocodedWaypoint> geocodedWaypoints = null;
    private List<Route_> routes = null;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return geocodedWaypoints;
    }

    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        this.geocodedWaypoints = geocodedWaypoints;
    }

    public List<Route_> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route_> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
