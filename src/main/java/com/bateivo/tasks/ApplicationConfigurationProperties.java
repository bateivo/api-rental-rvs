package com.bateivo.tasks;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("application")
public class ApplicationConfigurationProperties implements ApplicationConfiguration{
    private final int DEFAULT_PAGE_LIMIT = 50;

    private int max = DEFAULT_PAGE_LIMIT;

    @Override
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
