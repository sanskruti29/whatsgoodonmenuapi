package com.whatsgoodonmenu.api.database.visitor;

import java.util.concurrent.atomic.AtomicInteger;

import com.mongodb.client.DistinctIterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Component
public class VisitorTemplate {
    @Autowired MongoOperations mongoOperations;
    public int getUniqueVisits() {
        AtomicInteger count = new AtomicInteger(0);
        DistinctIterable<String> distinct = mongoOperations.getCollection("visitor")
            .distinct("ip", String.class);
        distinct.forEach(ip -> {
            log.info("Found unique ip: " + ip);
            count.incrementAndGet();
        });
	    return count.get();
	}
}