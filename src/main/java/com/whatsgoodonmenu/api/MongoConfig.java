package com.whatsgoodonmenu.api;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings.Builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration{

    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Override
    protected String getDatabaseName() {
        return "MenuApi";
    }

    @Override
    protected void configureClientSettings(Builder builder) {
        builder
        .applyToClusterSettings(settings->{
            settings.applyConnectionString(new ConnectionString(connectionString));
        });
    }
}