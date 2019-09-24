package com.ad.client;

import com.ad.client.utils.TestUtils;

public class RunAdServerTest {

    public static void main(String[] args) throws Exception {
        // Create Ads

        TestUtils runTestUtil = new TestUtils();
        runTestUtil.createAds();
        runTestUtil.registerImpressions();
        runTestUtil.registerClicks();
        for (int i = 0; i <= 10; i++)
            runTestUtil.getBestMatchAd();

        runTestUtil.deleteAd(4);
    }
}
