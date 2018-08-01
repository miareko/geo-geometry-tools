package io.github.miareko.geo.geojson.s2;

import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Loop;
import com.google.common.geometry.S2Point;
import com.google.common.geometry.S2Polygon;
import io.github.miareko.geo.geojson.GeoJsonMultiPolygon;
import io.github.miareko.geo.geojson.GeoJsonPoint;
import io.github.miareko.geo.geojson.GeoJsonPolygon;
import io.github.miareko.geo.geojson.type.Point;
import io.github.miareko.geo.geojson.type.Polygon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * generate {@link com.google.common.geometry.S2Region}
 *
 * created by miareko on 2018/5/18
 */
public final class S2RegionFactory {

    /**
     * generate S2Loop from a list of points
     * @param points point list
     * @return  an instance of S2Loop
     */
    public static S2Loop generateS2Loop(List<Point> points) {
        List<S2Point> list = new ArrayList<>(points.size());
        // the points order should be CCW
        pointsCCW(points);
        for (Point point : points) {
            list.add(S2PointFactory.from(point));
        }
        return new S2Loop(list);
    }

    /**
     * generate S2Polygon from GeoJsonPolygon
     * @param polygon a GeoJsonPolygon
     * @return  an instance of S2Polygon
     */
    public static S2Polygon generateS2Polygon(GeoJsonPolygon polygon) {
        return generateS2Polygon(polygon.getPolygon());
    }

    /**
     * generate S2Polygon from Polygon
     * @param polygon a Polygon
     * @return  an instance of S2Polygon
     */
    public static S2Polygon generateS2Polygon(Polygon polygon) {
        S2Loop outer = generateS2Loop(Arrays.asList(polygon.getOuterBoundaries()));
        if (polygon.getInnerBoundaries() == null || polygon.getInnerBoundaries().isEmpty()) {
            return new S2Polygon(outer);
        }
        List<S2Loop> loops = new ArrayList<>(polygon.getInnerBoundaries().size() + 1);
        loops.add(outer);

        for (Point[] points : polygon.getInnerBoundaries()) {
            loops.add(generateS2Loop(Arrays.asList(points)));
        }
        return new S2Polygon(loops);
    }

    /**
     * 由GeoJsonMultiPolygon生成S2Polygon
     * @param multiPolygon
     * @return
     */
    public static S2Polygon generateS2Polygon(GeoJsonMultiPolygon multiPolygon) {
        Polygon[] polygons = multiPolygon.getMultiPolygon().getPolygons();
        List<S2Loop> loops = new ArrayList<>();
        for (Polygon polygon : polygons) {
            S2Loop outer = generateS2Loop(Arrays.asList(polygon.getOuterBoundaries()));
            loops.add(outer);

            if (polygon.getInnerBoundaries() != null && !polygon.getInnerBoundaries().isEmpty()) {
                for (Point[] points : polygon.getInnerBoundaries()) {
                    loops.add(generateS2Loop(Arrays.asList(points)));
                }
            }
        }
        return new S2Polygon(loops);
    }

    /**
     * inverse the points if clockwise
     * @param points a list of Point
     */
    private static void pointsCCW(List<Point> points) {
        int pointIndexWithMinLng = 0;
        int size = points.size();
        for (int i = 1; i < size; i++) {
            if (points.get(i).getLongitude() < points.get(pointIndexWithMinLng).getLongitude()) {
                pointIndexWithMinLng = i;
            }
        }
        Point pointWithMinLng = points.get(pointIndexWithMinLng);
        Point prev = points.get((pointIndexWithMinLng - 1 + size) % size);
        Point next = points.get((pointIndexWithMinLng + 1) % size);

        double deltaY1 = pointWithMinLng.getLatitude() - prev.getLatitude();
        double deltaY2 = next.getLatitude() - pointWithMinLng.getLatitude();
        double deltaX1 = pointWithMinLng.getLongitude() - prev.getLongitude();
        double deltaX2 = next.getLongitude() - pointWithMinLng.getLongitude();

        double crossProduct = deltaX1 * deltaY2 - deltaY1 * deltaX2;
        if (crossProduct < 0) {
            Collections.reverse(points);
        }
    }

}
