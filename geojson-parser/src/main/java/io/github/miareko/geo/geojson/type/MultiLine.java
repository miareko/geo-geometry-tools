package io.github.miareko.geo.geojson.type;

import com.alibaba.fastjson.JSONArray;
import io.github.miareko.geo.geojson.assertion.Assert;

/**
 * created by miareko on 2018/5/17
 */
public class MultiLine {

    private Line[] lines;

    public MultiLine(Line[] lines) {
        this.lines = lines;
    }

    public MultiLine(JSONArray array) {
        Assert.notNull(array, "array of MultiLine Constructor");
        Assert.noLessThan(array.size(), 1, "array size of MultiLine Constructor");

        this.lines = new Line[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONArray line = array.getJSONArray(i);
            this.lines[i] = new Line(line);
        }
    }

    public Line[] getLines() {
        return lines;
    }
}
