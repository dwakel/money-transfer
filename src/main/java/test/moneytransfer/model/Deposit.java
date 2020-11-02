package test.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class Deposit {
    private final UUID id;
    private final UUID userId;
    private final double amount;
    private final Date paidAt;
    private final Date createdAt;

    public Deposit(@JsonProperty("id") UUID id,
                   @JsonProperty("userId") UUID userId,
                   @JsonProperty("amount") double amount,
                   @JsonProperty("paidAt") Date paidAt,
                   @JsonProperty("createdAt") Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.paidAt = paidAt;
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

    public Date getPaidAt() {
        return paidAt;
    }

}
