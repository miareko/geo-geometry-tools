package io.github.miareko.geo.geojson.type;

/**
 * created by miareko on 2018/5/17
 */
public class MultiPolygon {

    private Polygon[] polygons;

    public MultiPolygon(Polygon[] polygons) {
        this.polygons = polygons;
    }

    public Polygon[] getPolygons() {
        return polygons;
    }
}
