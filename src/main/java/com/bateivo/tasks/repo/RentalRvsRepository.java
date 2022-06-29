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

    private static final List<String> VALID_PROPERTY_NAMES = List.of("price");

    private final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public RentalRvsRepository(EntityManager entityManager, ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @ReadOnly
    public List<Rental> findAll(SortingAndOrderArguments args) {

        boolean isWhereAdded = false;

        String qlString = "SELECT r FROM Rental as r";

        if (args.getPriceMin().isPresent() && args.getPriceMax().isPresent())
        {
            qlString += " WHERE r.price >= " + args.getPriceMin().get() +
                    " AND r.price <= " + args.getPriceMax().get();

            isWhereAdded = true;
        }

        if (args.getIds().isPresent()) {

            if (!isWhereAdded) {

                qlString += " WHERE r.id IN (" + args.getIds().get()  + ')';

            } else {

                qlString += " AND r.id IN (" + args.getIds().get() + ')';
            }
        }

        if (args.getSort().isPresent() && VALID_PROPERTY_NAMES.contains(args.getSort().get())) {

            qlString += " ORDER BY r." + args.getSort().get();

            if (args.getOrder().isPresent()) {

                qlString += ' ' + args.getOrder().get().toLowerCase();

            } else {

                qlString += " ASC";
            }
        }

        TypedQuery<Rental> query = entityManager.createQuery(qlString, Rental.class);

        query.setMaxResults(args.getLimit().orElseGet(applicationConfiguration::getMax));

        args.getOffset().ifPresent(query::setFirstResult);

        List<Rental> rentals = query.getResultList();

        if (args.getNear().isPresent()) {

            List<Rental> nearRentals = new ArrayList<>();
            List<String> coordinates = Arrays.asList(args.getNear().get().split("\\s*,\\s*"));

            double centerPointLat = Double.parseDouble(coordinates.get(0));
            double centerPointLng = Double.parseDouble(coordinates.get(1));

            for (Rental rental : rentals) {

                if (arePointsNear(centerPointLat, centerPointLng, rental.getLat(), rental.getLng())) {

                    nearRentals.add(rental);
                }
            }

            return nearRentals;
        }

        return rentals;
    }

    @Override
    @ReadOnly
    public Optional<Rental> findById(long id) {

        return Optional.ofNullable(entityManager.find(Rental.class, id));
    }

    private boolean arePointsNear(double centerPointLat,
                                  double centerPointLng,
                                  double checkPointLat,
                                  double checkPointLng) {

        double km = 100 * 1.61;
        int ky = 40000 / 360;
        double kx = Math.cos(Math.PI * centerPointLat / 180.0) * ky;
        double dx = Math.abs(centerPointLng - checkPointLng) * kx;
        double dy = Math.abs(centerPointLat - checkPointLat) * ky;

        return Math.sqrt(dx * dx + dy * dy) <= km;
    }
}
