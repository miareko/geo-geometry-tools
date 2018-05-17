package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * created by miareko on 2018/5/17
 */
public final class GeoJson {

    public static GeoJsonObject parse(String source) {
        JSONObject jsonObj = JSON.parseObject(source);
        return GeoJsonObject.parse(jsonObj);
    }

    private GeoJson() {}
}
