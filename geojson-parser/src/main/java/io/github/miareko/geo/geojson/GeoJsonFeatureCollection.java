package io.github.miareko.geo.geojson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.miareko.geo.geojson.assertion.Assert;
import io.github.miareko.geo.geojson.type.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * created by miareko on 2018/5/17
 */
public class GeoJsonFeatureCollection extends GeoJsonObject {

    private List<GeoJsonFeature> features;

    GeoJsonFeatureCollection(JSONObject featureCollection) {
        super(Types.FEATURE_COLLECTION);
        JSONArray features = featureCollection.getJSONArray("features");
        Assert.notNull(features, "features of FeatureCollection");
        this.features = new ArrayList<>(features.size());
        for (int i = 0; i < features.size(); i++) {
            JSONObject feature = features.getJSONObject(i);
            this.features.add(new GeoJsonFeature(feature));
        }
    }

    public List<GeoJsonFeature> getFeatures() {
        return features;
    }
}
