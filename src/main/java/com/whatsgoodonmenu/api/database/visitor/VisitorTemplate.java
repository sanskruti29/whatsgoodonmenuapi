package com.whatsgoodonmenu.api.database.visitor;

import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

@Component
public class VisitorTemplate {
    @Autowired MongoOperations mongoOperations;

    public int getUniqueVisits() {
        Aggregation agg = Aggregation.newAggregation(
            Aggregation.group("ip"),
            Aggregation.count().as("count")
        );
        AggregationResults<Document> results = mongoOperations.aggregate(agg, "visitor", Document.class);
        Document result = results.getUniqueMappedResult();
        return result != null ? result.getInteger("count") : 0;
    }
}