package com.bateivo.tasks;

import com.bateivo.tasks.model.Rental;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.micronaut.http.HttpStatus.BAD_REQUEST;
import static io.micronaut.http.HttpStatus.NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testGetListAllReturnsAllRecords() {

        HttpRequest<?> request = HttpRequest.GET("/rvs");
        List<Rental> rentals = blockingClient.retrieve(request, Argument.of(List.class, Rental.class));

        assertEquals(30, rentals.size());
    }

    @Test
    public void testGetLimitOneReturnsOne() {

        HttpRequest<?> request = HttpRequest.GET("/rvs?limit=1");
        List<Rental> rentals = blockingClient.retrieve(request, Argument.of(List.class, Rental.class));

        assertEquals(1, rentals.size());
    }

    @Test
    void supplyAnInvalidOrderTriggersValidationFailure() {
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, () ->
                blockingClient.exchange(HttpRequest.GET("/rvs?order=foo"))
        );

        assertNotNull(thrown.getResponse());
        assertEquals(BAD_REQUEST, thrown.getStatus());
    }

    @Test
    void testFindNonExistingRentalReturns404() {
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, () ->
                blockingClient.exchange(HttpRequest.GET("/rvs/0"))
        );

        assertNotNull(thrown.getResponse());
        assertEquals(NOT_FOUND, thrown.getStatus());
    }

    @Test
    void testFindByIdReturnsExpectedRecord() {

        HttpRequest<?> request = HttpRequest.GET("/rvs/105564");

        Rental rental = blockingClient.retrieve(request, Rental.class);

        assertEquals("Daisy", rental.getName());
    }
}
