package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.assertion.Assert;
import io.github.miareko.geo.geojson.type.Line;
import io.github.miareko.geo.geojson.type.Point;
import io.github.miareko.geo.geojson.type.Types;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonLineString extends GeoJsonObject {

    private Line coordinates;

    GeoJsonLineString(JSONObject lineString) {
        super(Types.LINE_STRING);
        JSONArray coordinates = lineString.getJSONArray("coordinates");
        this.coordinates = new Line(coordinates);
    }

    public Point getStartPoint() {
        return coordinates.getStart();
    }

    public Point getEndPoint() {
        return coordinates.getEnd();
    }
}
