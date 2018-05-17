package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.assertion.Assert;
import io.github.miareko.geo.geojson.type.Point;
import io.github.miareko.geo.geojson.type.Types;

public class GeoJsonPoint extends GeoJsonObject {

    private Point coordinates;

    GeoJsonPoint(JSONObject point) {
        super(Types.POINT);
        JSONArray coordinates = point.getJSONArray("coordinates");
        this.coordinates = new Point(coordinates);
    }

    public Double getX() {
        return coordinates.getLatitude();
    }

    public Double getY() {
        return coordinates.getLongitude();
    }

}