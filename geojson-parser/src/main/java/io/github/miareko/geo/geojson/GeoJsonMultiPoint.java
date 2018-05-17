package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.type.MultiPoint;
import io.github.miareko.geo.geojson.type.Types;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonMultiPoint extends GeoJsonObject {

    private MultiPoint coordinates;

    GeoJsonMultiPoint(JSONObject multiPoint) {
        super(Types.MULTI_POINT);
        JSONArray coordinates = multiPoint.getJSONArray("coordinates");
        this.coordinates = new MultiPoint(coordinates);
    }

    public MultiPoint getMultiPoint() {
        return coordinates;
    }
}
