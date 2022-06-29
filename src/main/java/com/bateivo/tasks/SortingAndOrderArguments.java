package com.bateivo.tasks;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

@Introspected
public class SortingAndOrderArguments {

    @Nullable
    @PositiveOrZero
    private Integer offset;

    @Nullable
    @Positive
    private Integer limit;

    @Nullable
    @Pattern(regexp = "price")
    private String sort;

    @Nullable
    @Pattern(regexp = "asc|ASC|desc|DESC")
    private String order;

    @Nullable
    @Positive
    private Integer priceMin;

    @Nullable
    @Positive
    private Integer priceMax;

    @Nullable
    @Pattern(regexp = "[\\d, /,]+")
    private String ids;

    @Nullable
    @Pattern(regexp = "^((\\-?|\\+?)?\\d+(\\.\\d+)?),\\s*((\\-?|\\+?)?\\d+(\\.\\d+)?)$")
    private String near;

    public Optional<String> getIds() { return Optional.ofNullable(ids); }

    public void setIds(@Nullable String ids) { this.ids = ids; }

    public Optional<Integer> getOffset() {
        return Optional.ofNullable(offset);
    }

    public void setOffset(@Nullable Integer offset) {
        this.offset = offset;
    }

    public Optional<Integer> getLimit() {
        return Optional.ofNullable(limit);
    }

    public void setLimit(@Nullable Integer limit) {
        this.limit = limit;
    }

    public Optional<String> getSort() {
        return Optional.ofNullable(sort);
    }

    public void setSort(@Nullable String sort) {
        this.sort = sort;
    }

    public Optional<String> getOrder() {
        return Optional.ofNullable(order);
    }

    public void setOrder(@Nullable String order) {
        this.order = order;
    }

    public Optional<Integer> getPriceMin() { return Optional.ofNullable(priceMin); }

    public void setPriceMin(@Nullable Integer priceMin) { this.priceMin = priceMin; }

    public Optional<Integer> getPriceMax() { return Optional.ofNullable(priceMax); }

    public void setPriceMax(@Nullable Integer priceMax) { this.priceMax = priceMax; }

    public Optional<String> getNear() { return Optional.ofNullable(near); }

    public void setNear(@Nullable String near) { this.near = near; }
}