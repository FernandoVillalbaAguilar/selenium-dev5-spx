package com.metalsa.spx.dev5.main;

import java.util.TreeMap;

public class TestStepInfo {
	private String description;
    private TreeMap<String, String> screenshots;

    public TestStepInfo(String description) {
        this.description = description;
        this.screenshots = new TreeMap<>();
    }

    public String getDescription() {
        return description;
    }

    public void addScreenshot(String key, String value) {
        screenshots.put(key, value);
    }

    public TreeMap<String, String> getScreenshots() {
        return screenshots;
    }
}
