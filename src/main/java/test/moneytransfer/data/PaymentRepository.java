package test.moneytransfer.data;

import test.moneytransfer.model.Balance;
import test.moneytransfer.model.Deposit;
import test.moneytransfer.model.PaymentTransaction;
import test.moneytransfer.model.Withdrawal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PaymentRepository implements IPaymentRepository {

    private static List<Balance> BalanceTable = new ArrayList<Balance>();
    private static List<Deposit> DepositTable = new ArrayList<Deposit>();
    private static List<Withdrawal> WithdrawalTable = new ArrayList<Withdrawal>();
    private static List<PaymentTransaction> PaymentTransactionTable = new ArrayList<PaymentTransaction>();

    @Override
    public Deposit addDeposit(UUID id, Deposit depositModel) {
        return null;
    }

    @Override
    public Optional<Deposit> listDepositsByUserId(UUID userId) {
        return Optional.empty();
    }

    @Override
    public Optional<Deposit> findDepositById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Withdrawal addWithdrawal(UUID id, Withdrawal depositModel) {
        return null;
    }

    @Override
    public Optional<Withdrawal> listWithdrawalByUserId(UUID userId) {
        return Optional.empty();
    }

    @Override
    public Optional<Withdrawal> findWithdrawalById(UUID id) {
        return Optional.empty();
    }

    @Override
    public PaymentTransaction createPaymentTransaction(UUID id, PaymentTransaction payment) {
        return null;
    }

    @Override
    public Optional<PaymentTransaction> listPaymentById(UUID userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UUID> findUserBalanceByUserId(UUID userId, Balance balanceModel) {
        return Optional.empty();
    }

    @Override
    public Balance AddUserBalance(UUID userId, Balance balanceModel) {
        return null;
    }

    @Override
    public Balance UpdateUserBalance(UUID userId, Balance balanceModel) {
        return null;
    }
}
