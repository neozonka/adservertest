package com.ad.client.utils;

import java.util.HashMap;

public class CommonUtils {
    public static final String serverAddress = "http://localhost:8080";

    public enum EndPoints {
        createAd("createnewad"),
        getAd("getad/{adid}"),
        gerAllAds("getallads"),
        updateAd("updatead"),
        deleteAd("deletead/{adid}"),
        registerImpression("registerimpression"),
        registerClick("registerclick"),
        getBestMatchAd("getbestmatchad");

        private String value;

        public String getValue() {
            return this.value;
        }

        EndPoints(String value) {
            this.value = value;
        }
    }

    public static final int numOfTestAds = 6;

    /**
     * Assiging adId to nof of times to Impression mapping.
     *
     * @return Map of AdId to no of times it should be Impressioned.
     */
    public static HashMap<Integer, Integer> getImpressionTestSpec() {
        return new HashMap<Integer, Integer>() {{
            put(1, 100);
            put(2, 130);
            put(3, 140);
            put(4, 100);
            put(5, 300);
            put(6, 230);
        }};
    }

    /**
     * Assiging adId to nof of times to click mapping.
     *
     * @return Map of AdId to no of times it should be clicked.
     */
    public static HashMap<Integer, Integer> getClickTestSpec() {
        return new HashMap<Integer, Integer>() {{
            put(1, 20);
            put(2, 20);
            put(3, 22);
            put(4, 5);
            put(5, 50);
            put(6, 60);
        }};
    }
}
