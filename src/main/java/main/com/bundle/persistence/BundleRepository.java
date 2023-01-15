package main.com.bundle.persistence;


import main.com.bundle.document.BundleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BundleRepository extends MongoRepository<BundleDocument, String> {

}
