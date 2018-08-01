package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * created by miareko on 2018/5/17
 */
public final class GeoJson {

    /**
     * parse json to GeoJsonObject
     * @param source json string
     * @param <T> subclass type of GeoJsonObject
     * @return an instance of GeoJsonObject's subclass
     */
    public static <T extends GeoJsonObject> T parse(String source) {
        JSONObject jsonObject = JSON.parseObject(source);
        return (T) GeoJsonObject.parse(jsonObject);
    }

    private GeoJson() {}
}
