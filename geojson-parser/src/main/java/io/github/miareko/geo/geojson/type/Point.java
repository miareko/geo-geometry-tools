package io.github.miareko.geo.geojson.type;

import com.alibaba.fastjson.JSONArray;
import io.github.miareko.geo.geojson.assertion.Assert;

/**
 * created by miareko on 2018/5/17
 */
public class Point {

    private Double latitude;
    private Double longitude;

    public Point(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Point(JSONArray array) {
        Assert.notNull(array, "array of Point Constructor");
        Assert.equals(array.size(), 2, "Point array size must be 2");
        this.latitude = array.getDouble(1);
        this.longitude = array.getDouble(0);
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
