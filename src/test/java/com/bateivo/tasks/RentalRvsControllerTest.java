package com.bateivo.tasks;

import com.bateivo.tasks.dto.Rental;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class RentalRvsControllerTest {

    private BlockingHttpClient blockingClient;

    @Inject
    @Client("/")
    HttpClient client;

    @BeforeEach
    void setup() {
        blockingClient = client.toBlocking();
    }

    @Test
    public void testGetListAll() {

        HttpRequest<?> request = HttpRequest.GET("/rvs/list");
        List<Rental> rentals = blockingClient.retrieve(request, Argument.of(List.class, Rental.class));

        assertEquals(30, rentals.size());

    }

    @Test
    public void testGetOne() {

        HttpRequest<?> request = HttpRequest.GET("/rvs/list?max=1");
        List<Rental> rentals = blockingClient.retrieve(request, Argument.of(List.class, Rental.class));

        assertEquals(1, rentals.size());

    }
}
