package test.moneytransfer.model;

import java.util.Date;
import java.util.UUID;

public class Balance {

    private final UUID id;
    private final UUID userId;
    private final double actualBalance;
    private final double availableBalance;
    private final Date createdAt;

    public Balance(UUID id, UUID userId, double actualBalance, double availableBalance, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.actualBalance = actualBalance;
        this.availableBalance = availableBalance;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getActualBalance() {
        return actualBalance;
    }
    public double getAvailableBalance() {
        return availableBalance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
