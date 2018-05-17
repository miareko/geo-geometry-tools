package io.github.miareko.geo.geojson.type;

import com.alibaba.fastjson.JSONArray;
import io.github.miareko.geo.geojson.assertion.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * created by miareko on 2018/5/17
 */
public class Polygon {

    private Point[] outerBoundaries;
    private List<Point[]> innerBoundaries;

    public Polygon(JSONArray array) {
        Assert.notNull(array, "array of Polygon Constructor");
        Assert.noLessThan(array.size(), 1, "array size of Polygon Constructor");
        if (array.size() > 0) {
            JSONArray outerBoundaryArray = array.getJSONArray(0);
            this.outerBoundaries = buildBoundaries(outerBoundaryArray);
        }
        if (array.size() > 1) {
            this.innerBoundaries = new ArrayList<>(array.size() - 1);
            for (int i = 1; i < array.size(); i++) {
                JSONArray innerBoundaryArray = array.getJSONArray(i);
                this.innerBoundaries.add(buildBoundaries(innerBoundaryArray));
            }
        }
    }

    private Point[] buildBoundaries(JSONArray array) {
        Point[] boundaries = new Point[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONArray point = array.getJSONArray(i);
            boundaries[i] = new Point(point);
        }
        return boundaries;
    }

    public List<Point[]> getInnerBoundaries() {
        return innerBoundaries;
    }

    public Point[] getOuterBoundaries() {
        return outerBoundaries;
    }
}
