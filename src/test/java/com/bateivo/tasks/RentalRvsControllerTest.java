package com.bateivo.tasks;

import com.bateivo.tasks.dto.Rentals;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class RentalRvsControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testGetListAll() {

        HttpRequest<?> request = HttpRequest.GET("/rvs/list");
        List<Rentals> rentals = client.toBlocking().retrieve(request, Argument.of(List.class, Rentals.class));

        assertEquals(30, rentals.size());

    }
}
