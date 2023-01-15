package main.com.bundle.configration.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@RequiredArgsConstructor
public class MongoConfiguration extends AbstractMongoConfiguration {

    private static final String DATABASE_NAME = "bundle";
    private static final String MAPPING_BASE_PACKAGE = "com.bundle";

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    }

    @Override
    protected String getMappingBasePackage() {
        return MAPPING_BASE_PACKAGE;
    }
}
