package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.assertion.Assert;
import io.github.miareko.geo.geojson.type.MultiPolygon;
import io.github.miareko.geo.geojson.type.Polygon;
import io.github.miareko.geo.geojson.type.Types;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonMultiPolygon extends GeoJsonObject {

    private MultiPolygon coordinates;

    GeoJsonMultiPolygon(JSONObject multiPolygon) {
        super(Types.MULTI_POLYGON);
        JSONArray coordinates = multiPolygon.getJSONArray("coordinates");
        Assert.notNull(coordinates, "coordinates of MultiPolygon");
        Polygon[] polygons = new Polygon[coordinates.size()];
        for (int i = 0; i < coordinates.size(); i++) {
            polygons[i] = new Polygon(coordinates.getJSONArray(i));
        }
        this.coordinates = new MultiPolygon(polygons);
    }

    public MultiPolygon getMultiPolygon() {
        return coordinates;
    }
}
