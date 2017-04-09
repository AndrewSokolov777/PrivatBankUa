
package exp.privatebank.pojo.RoutePojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Route_ {

    private Bounds bounds;
    private String copyrights;
    private List<Leg> legs = null;
    private Overview_polyline overview_polyline;
    private String summary;
    private List<Object> warnings = null;
    private List<Object> waypointOrder = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public Overview_polyline getOverview_polyline ()
    {
        return overview_polyline;
    }

    public void setOverview_polyline (Overview_polyline overview_polyline)
    {
        this.overview_polyline = overview_polyline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

    public List<Object> getWaypointOrder() {
        return waypointOrder;
    }

    public void setWaypointOrder(List<Object> waypointOrder) {
        this.waypointOrder = waypointOrder;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
