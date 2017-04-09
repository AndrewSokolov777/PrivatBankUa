package exp.privatebank.pojo.RoutePojo;

/**
 * Created by User on 25.01.2017.
 */

public class Overview_polyline {

    private String points;

    public String getPoints ()
    {
        return points;
    }

    public void setPoints (String points)
    {
        this.points = points;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [points = "+points+"]";
    }
}
