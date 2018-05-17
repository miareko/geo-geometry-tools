package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.type.Polygon;
import io.github.miareko.geo.geojson.type.Types;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonPolygon extends GeoJsonObject {

    private Polygon coordinates;

    GeoJsonPolygon(JSONObject polygon) {
        super(Types.POLYGON);
        JSONArray coordinates = polygon.getJSONArray("coordinates");
        this.coordinates = new Polygon(coordinates);
    }

    public Polygon getPolygon() {
        return coordinates;
    }
}
