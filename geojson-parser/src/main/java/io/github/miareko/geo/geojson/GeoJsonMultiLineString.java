package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.type.MultiLine;
import io.github.miareko.geo.geojson.type.Types;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonMultiLineString extends GeoJsonObject {

    private MultiLine coordinates;

    GeoJsonMultiLineString(JSONObject multiLineString) {
        super(Types.MULTI_LINE_STRING);
        JSONArray coordinates = multiLineString.getJSONArray("coordinates");
        this.coordinates = new MultiLine(coordinates);
    }

    public MultiLine getMultiLine() {
        return coordinates;
    }
}
