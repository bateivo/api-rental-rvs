package com.bateivo.tasks.repo;

import com.bateivo.tasks.ApplicationConfiguration;
import com.bateivo.tasks.SortingAndOrderArguments;
import com.bateivo.tasks.dto.Rental;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

@Singleton
public class RentalRvsRepository implements IRentalRvsRepository{

    private static final List<String> VALID_PROPERTY_NAMES = Arrays.asList("id", "name");

    private final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public RentalRvsRepository(EntityManager entityManager, ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @ReadOnly
    public List<Rental> findAll(SortingAndOrderArguments args) {
        String qlString = "SELECT r FROM Rental as r";
        if (args.getOrder().isPresent() && args.getSort().isPresent() && VALID_PROPERTY_NAMES.contains(args.getSort().get())) {
            qlString += " ORDER BY r." + args.getSort().get() + ' ' + args.getOrder().get().toLowerCase();
        }
        TypedQuery<Rental> query = entityManager.createQuery(qlString, Rental.class);
        query.setMaxResults(args.getMax().orElseGet(applicationConfiguration::getMax));
        args.getOffset().ifPresent(query::setFirstResult);

        return query.getResultList();
    }

    @ReadOnly
    public List<Rental> findAll() {

        String qlString = "SELECT r FROM Rental as r";

        TypedQuery<Rental> query = entityManager.createQuery(qlString, Rental.class);

        query.setMaxResults(applicationConfiguration.getMax());

        return query.getResultList();
    }

}
