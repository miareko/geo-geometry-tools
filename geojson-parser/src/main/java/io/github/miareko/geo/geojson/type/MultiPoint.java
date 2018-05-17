package io.github.miareko.geo.geojson.type;

import com.alibaba.fastjson.JSONArray;
import io.github.miareko.geo.geojson.assertion.Assert;

/**
 * created by miareko on 2018/5/17
 */
public class MultiPoint {

    private Point[] points;

    public MultiPoint(Point[] points) {
        this.points = points;
    }

    public MultiPoint(JSONArray array) {
        Assert.notNull(array, "array of MultiPoint Constructor");
        Assert.noLessThan(array.size(), 1, "array size of MultiPoint Constructor");

        this.points = new Point[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONArray point = array.getJSONArray(i);
            this.points[i] = new Point(point);
        }
    }

    public Point[] getPoints() {
        return points;
    }
}
