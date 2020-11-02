package test.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class PaymentTransaction {
    private final UUID id;
    private final UUID userId;
    private final double amount;
    private final PaymentType type;
    private final Date createdAt;
    private final double ownerBalance;

    public PaymentTransaction(@JsonProperty("id") UUID id,
                              @JsonProperty("userId") UUID userId,
                              @JsonProperty("amount") double amount,
                              @JsonProperty("type") PaymentType type,
                              @JsonProperty("cratedAt") Date createdAt,
                              @JsonProperty("ownerBalance") double ownerBalance) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt;
        this.ownerBalance = ownerBalance;
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

    public PaymentType getPaymentType() {
        return type;
    }

    public double getOwnerBalance() {
        return ownerBalance;
    }
}
