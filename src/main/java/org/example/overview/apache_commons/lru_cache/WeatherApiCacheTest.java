package org.example.overview.apache_commons.lru_cache;

import org.apache.commons.collections4.map.LRUMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherApiCacheTest {
    private static final int CACHE_SIZE = 100;
    private final Map<String, CachedResponse> cache;
    private static final String API_KEY = "XXXXXXXXXX"; // Replace with a valid API key
    private static final double TEST_LAT = 52.52;  // Berlin
    private static final double TEST_LON = 13.41;

    public WeatherApiCacheTest() {
        this.cache = Collections.synchronizedMap(new LRUMap<>(CACHE_SIZE));
    }

    public String getWeather(double lat, double lon) {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&units=metric&appid=" + API_KEY;
        String cacheKey = lat + "," + lon;

        // Check if response exists in cache
        CachedResponse cachedResponse = cache.get(cacheKey);
        if (cachedResponse != null) {
            return cachedResponse.getData();
        }

        // Fetch from API
        System.out.println("🔄 Fetching real API data...");
        String response = fetchDataFromApi(url);

        // Store only valid responses in cache
        if (!response.contains("\"error\"")) {
            cache.put(cacheKey, new CachedResponse(response));
        }

        return response;
    }

    private String fetchDataFromApi(String urlString) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String output;
                while ((output = br.readLine()) != null) {
                    response.append(output);
                }
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Failed to fetch weather data\"}";
        }

        return response.toString();
    }

    public static void main(String[] args) {
        WeatherApiCacheTest weatherCache = new WeatherApiCacheTest();

        // **STEP 1: Fetch Real API Response Once**
        long startApiTime = System.currentTimeMillis();
        String realApiResponse = weatherCache.getWeather(TEST_LAT, TEST_LON);
        long endApiTime = System.currentTimeMillis();
        System.out.println("🌍 Real API Call Time: " + (endApiTime - startApiTime) + " ms\n");

        // **STEP 2: Fetch from Cache 10,000 Times**
        ExecutorService executor = Executors.newFixedThreadPool(50);
        long startCacheTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> weatherCache.getWeather(TEST_LAT, TEST_LON));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        long endCacheTime = System.currentTimeMillis();
        System.out.println("⚡ Cache Fetch Time (10,000 requests): " + (endCacheTime - startCacheTime) + " ms");
    }
}

// CachedResponse with Expiration
class CachedResponse {
    private final String data;
    private final long timestamp;

    public CachedResponse(String data) {
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public String getData() {
        return data;
    }
}
