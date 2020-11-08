package test.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class Withdrawal {
    private final UUID id;
    private final UUID userId;
    private final double amount;
    private final Date disbursedAt;
    private final Date createdAt;

    public Withdrawal(@JsonProperty("id") UUID id,
                   @JsonProperty("userId") UUID userId,
                   @JsonProperty("amount") double amount,
                   @JsonProperty("disbursedAt") Date disbursedAt,
                   @JsonProperty("createdAt") Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.disbursedAt = disbursedAt;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDisbursedAt() {
        return disbursedAt;
    }
}
