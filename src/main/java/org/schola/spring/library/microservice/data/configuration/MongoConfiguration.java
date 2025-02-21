package org.schola.spring.library.microservice.data.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.schola.spring.library.microservice.data.repository.mongo")
public class MongoConfiguration {
}
