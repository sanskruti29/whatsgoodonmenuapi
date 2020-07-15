package com.whatsgoodonmenu.api;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings.Builder;
import com.whatsgoodonmenu.api.database.visitor.ZonedDateTimeReadConverter;
import com.whatsgoodonmenu.api.database.visitor.ZonedDateTimeWriteConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

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
    
    @Override
    public MongoCustomConversions customConversions() {
        List<Converter<?,?>> converters = new ArrayList<>();
        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());
        return new MongoCustomConversions(converters);
    }
}