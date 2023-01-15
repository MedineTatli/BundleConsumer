package main.com.bundle.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.com.bundle.document.BundleDocument;
import main.com.bundle.persistence.BundleRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class BundleDataConsumer {

    private BundleRepository bundleRepository;

    @RabbitListener(queues = "bundle.data.queue", containerFactory = "simpleRabbitListenerContainerFactory")
    public void listenToQueue(String json) {
        log.info("Data consumed : {}", json);
        BundleDocument bundleDocument = new BundleDocument();
        bundleDocument.setData(Integer.parseInt(json));
        bundleRepository.save(bundleDocument);

    }
}
