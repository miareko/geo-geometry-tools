package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.type.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonGeometryCollection extends GeoJsonObject {

    private List<GeoJsonObject> geometries;

    GeoJsonGeometryCollection(JSONObject geometryCollection) {
        super(Types.GEOMETRY_COLLECTION);
        JSONArray geometries = geometryCollection.getJSONArray("geometries");
        this.geometries = new ArrayList<>(geometries.size());
        for (int i = 0; i < geometries.size(); i++) {
            this.geometries.add(parse(geometries.getJSONObject(i)));
        }
    }

    public List<GeoJsonObject> getGeometries() {
        return geometries;
    }
}
