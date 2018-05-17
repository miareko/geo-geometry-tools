package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.assertion.Assert;
import io.github.miareko.geo.geojson.type.Types;

import java.util.Map;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonFeature extends GeoJsonObject {

    private String id;
    private Map<String, Object> properties;

    private GeoJsonObject geometry;

    GeoJsonFeature(JSONObject feature) {
        super(Types.FEATURE);
        if (feature.containsKey("id")) {
            this.id = feature.getString("id");
        }
        if (feature.containsKey("properties")) {
            this.properties = feature.getJSONObject("properties");
        }
        if (feature.containsKey("geometry")) {
            JSONObject geometry = feature.getJSONObject("geometry");
            this.geometry = parse(geometry);
        }
    }

    public String getId() {
        return id;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public GeoJsonObject getGeometry() {
        return geometry;
    }
}
