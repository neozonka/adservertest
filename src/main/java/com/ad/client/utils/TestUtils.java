package com.ad.client.utils;

import com.ebay.search.ep.services.HeaderUtils;
import com.ebay.search.ep.services.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestUtils {

    Random random = new Random();


    public void createAds() throws Exception {
        for (int adid = 1; adid <= CommonUtils.numOfTestAds; adid++) {
            String requestUrl = CommonUtils.serverAddress + "/" + CommonUtils.EndPoints.createAd.getValue();
            System.out.println("API Endpoint: " + requestUrl);
            HttpClientUtils httpClientUtils = new HttpClientUtils();
            HeaderUtils headerUtils = new HeaderUtils();
            Map<String, String> defaultHeaders = headerUtils.getDefaultHeaders();
            defaultHeaders.put("content-type", "application/json");
            String content = "{" +
                    "\"custName\": \"Ad " + adid + "\"," +
                    "\"email\": \"test@email.com\"," +
                    "\"sTime\": \"1000\"," +
                    "\"catId\": \"" + (random.nextInt(4) + 1) + "\"" +
                    "}";

            System.out.println("Creating Ad " + content);
            String response = httpClientUtils.post(requestUrl, defaultHeaders, false, content);
            Thread.sleep(100);

            System.out.println("Response is " + response);
        }
    }

    public void registerImpressions() throws Exception {

        String requestUrl = CommonUtils.serverAddress + "/" + CommonUtils.EndPoints.registerImpression.getValue();
        System.out.println("API Endpoint: " + requestUrl);

        HashMap<Integer, Integer> impressionTestSpec = CommonUtils.getImpressionTestSpec();
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        HeaderUtils headerUtils = new HeaderUtils();
        Map<String, String> defaultHeaders = headerUtils.getDefaultHeaders();
        defaultHeaders.put("content-type", "application/json");
        for (Map.Entry<Integer, Integer> spec : impressionTestSpec.entrySet()) {
            for (int i = 1; i <= spec.getValue(); i++) {
                String content = "{" +
                        "\"catId\": \"" + (random.nextInt(4) + 1) + "\"," +
                        "\"adId\": \"" + spec.getKey() + "\"," +
                        "\"rLogId\":\"123213\" " +
                        "}";
                System.out.println("Content is " + content);
                String response = httpClientUtils.post(requestUrl, defaultHeaders, false, content);
                Thread.sleep(100);

                System.out.println("Response is " + response);
            }
        }
    }

    public void registerClicks() throws Exception {

        String requestUrl = CommonUtils.serverAddress + "/" + CommonUtils.EndPoints.registerClick.getValue();
        System.out.println("API Endpoint: " + requestUrl);

        HashMap<Integer, Integer> clickTestSpec = CommonUtils.getClickTestSpec();
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        HeaderUtils headerUtils = new HeaderUtils();
        Map<String, String> defaultHeaders = headerUtils.getDefaultHeaders();
        defaultHeaders.put("content-type", "application/json");

        for (Map.Entry<Integer, Integer> spec : clickTestSpec.entrySet()) {
            for (int i = 1; i <= spec.getValue(); i++) {
                String content = "{" +
                        "\"catId\": \"" + (random.nextInt(4) + 1) + "\"," +
                        "\"adId\":\"" + spec.getKey() + "\"," +
                        "\"impressionId\":\"" + random.nextInt(CommonUtils.numOfTestAds) + "\"," + // randomly associating click with an ad.
                        "\"rLogId\":\"123213\" " +
                        "}";
                System.out.println("Content is " + content);
                String response = httpClientUtils.post(requestUrl, defaultHeaders, false, content);
                Thread.sleep(100);
                System.out.println("Response is " + response);
            }
        }
    }

    public void getBestMatchAd() throws Exception {
        String requestUrl = CommonUtils.serverAddress + "/" + CommonUtils.EndPoints.getBestMatchAd.getValue();
        System.out.println("API Endpoint: " + requestUrl);
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        HeaderUtils headerUtils = new HeaderUtils();
        Map<String, String> defaultHeaders = headerUtils.getDefaultHeaders();
        defaultHeaders.put("content-type", "application/json");
        String response = httpClientUtils.get(requestUrl, defaultHeaders);
        Thread.sleep(100);
        System.out.println("Response is " + response);


    }
}
