package io.github.miareko.geo.geojson.type;

import io.github.miareko.geo.geojson.assertion.Assert;
import io.github.miareko.geo.geojson.assertion.UnsupportedTypeException;

/**
 * created by miareko on 2018/5/17
 */
public enum Types {

    POINT("Point"),
    LINE_STRING("LineString"),
    POLYGON("Polygon"),
    MULTI_POINT("MultiPoint"),
    MULTI_LINE_STRING("MultiLineString"),
    MULTI_POLYGON("MultiPolygon"),
    FEATURE("Feature"),
    FEATURE_COLLECTION("FeatureCollection"),
    GEOMETRY_COLLECTION("GeometryCollection");

    public String type;

    Types(String type) {
        this.type = type;
    }

    public static Types of(String type) {
        Assert.notNull(type, "type");
        for (Types t : values()) {
            if (t.type.equalsIgnoreCase(type)) {
                return t;
            }
        }
        throw new UnsupportedTypeException(String.format("unsupported GeoJson type: %s", type));
    }
}
