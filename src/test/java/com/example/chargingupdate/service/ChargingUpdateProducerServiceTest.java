package com.example.chargingupdate.service;

import com.example.chargingupdate.dto.ChargingRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChargingUpdateProducerServiceTest {

    @Mock
    private KafkaTemplate<String, ChargingRequest> kafkaTemplate;

    @InjectMocks
    private ChargingUpdateProducerService chargingUpdateProducerService;

    @Test
    void testSendMessage_verifyMethodCalled() {
        ChargingRequest chargingRequest = new ChargingRequest();
        chargingUpdateProducerService.sendMessage(chargingRequest);

        Mockito.verify(kafkaTemplate, Mockito.times(1))
                .send(Mockito.any(), Mockito.any(), Mockito.any());

    }
}