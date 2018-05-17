package io.github.miareko.geo.geojson.assertion;

/**
 * created by miareko on 2018/5/17
 */
public class Assert {

    public static void equals(Object one, Object other, String message) {
        if (one == null || other == null || !one.equals(other)) {
            throw new AssertionException(message);
        }
    }

    public static void notNull(Object obj, String name) {
        if (obj == null) {
            throw new AssertionException(String.format("%s must not be null", name));
        }
    }

    public static void noLessThan(Number given, Number min, String name) {
        if (given.doubleValue() < min.doubleValue()) {
            throw new AssertionException(String.format("%s must not be less than %d", name, min));
        }
    }

}
