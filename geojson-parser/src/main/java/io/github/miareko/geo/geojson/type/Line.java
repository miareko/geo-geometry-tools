package io.github.miareko.geo.geojson.type;

import com.alibaba.fastjson.JSONArray;
import io.github.miareko.geo.geojson.assertion.Assert;

/**
 * created by miareko on 2018/5/17
 */
public class Line {

    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(JSONArray array) {
        Assert.notNull(array, "array of Line Constructor");
        Assert.noLessThan(array.size(), 2, "array size of Line Constructor");

        JSONArray startArray = array.getJSONArray(0);
        JSONArray endArray = array.getJSONArray(1);

        this.start = new Point(startArray);
        this.end = new Point(endArray);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
