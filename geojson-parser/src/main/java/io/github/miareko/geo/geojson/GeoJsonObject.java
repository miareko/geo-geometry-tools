package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.assertion.UnsupportedTypeException;
import io.github.miareko.geo.geojson.type.Types;

public class GeoJsonObject {

    private Types type;

    GeoJsonObject(Types type) {
        this.type = type;
    }

    public Types getType() {
        return type;
    }

    static GeoJsonObject parse(JSONObject json) {
        String type = json.getString("type");
        Types geoJsonType = Types.of(type);
        switch (geoJsonType) {
            case POINT:
                return new GeoJsonPoint(json);
            case LINE_STRING:
                return new GeoJsonLineString(json);
            case POLYGON:
                return new GeoJsonPolygon(json);
            case MULTI_POINT:
                return new GeoJsonMultiPoint(json);
            case MULTI_LINE_STRING:
                return new GeoJsonMultiLineString(json);
            case MULTI_POLYGON:
                return new GeoJsonMultiPolygon(json);
            case FEATURE_COLLECTION:
                return new GeoJsonFeatureCollection(json);
            case GEOMETRY_COLLECTION:
                return new GeoJsonGeometryCollection(json);
            default:
                throw new UnsupportedTypeException("unsupported GeoJson type");

        }
    }
}
