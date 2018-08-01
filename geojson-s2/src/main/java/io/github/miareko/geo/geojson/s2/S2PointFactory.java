package io.github.miareko.geo.geojson.s2;

import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Point;
import io.github.miareko.geo.geojson.GeoJson;
import io.github.miareko.geo.geojson.GeoJsonObject;
import io.github.miareko.geo.geojson.GeoJsonPoint;
import io.github.miareko.geo.geojson.type.Point;

/**
 * generate {@link com.google.common.geometry.S2Point}
 *
 * created by miareko on 2018/8/2
 */
public final class S2PointFactory {

    /**
     * generate S2Point from GeoJsonPoint
     * @param point a GeoJsonPoint
     * @return an instance of S2Point
     */
    public static S2Point from(GeoJsonPoint point) {
        S2LatLng s2LatLng = S2LatLng.fromDegrees(point.getX(), point.getY());
        return s2LatLng.toPoint();
    }

    /**
     * generate S2Point from Point
     * @param point a Point
     * @return an instance of S2Point
     */
    public static S2Point from(Point point) {
        S2LatLng s2LatLng = S2LatLng.fromDegrees(point.getLatitude(), point.getLongitude());
        return s2LatLng.toPoint();
    }

    /**
     * generate S2Point from a geojson string
     * @param json geojson string
     * @return an instance of S2Point
     */
    public static S2Point from(String json) {
        GeoJsonPoint point = GeoJson.parse(json);
        return from(point);
    }

}
