package test.moneytransfer.data;

import test.moneytransfer.model.Balance;
import test.moneytransfer.model.Deposit;
import test.moneytransfer.model.PaymentTransaction;
import test.moneytransfer.model.Withdrawal;

import java.util.*;

public class PaymentRepository implements IPaymentRepository {

    private static List<Balance> BalanceTable = new ArrayList<Balance>();
    private static List<Deposit> DepositTable = new ArrayList<Deposit>();
    private static List<Withdrawal> WithdrawalTable = new ArrayList<Withdrawal>();
    private static List<PaymentTransaction> PaymentTransactionTable = new ArrayList<PaymentTransaction>();

    @Override
    public Optional<Deposit> addDeposit(UUID id, Deposit depositModel) {
        DepositTable.add(new Deposit(id,
                depositModel.getUserId(),
                depositModel.getAmount(),
                depositModel.getPaidAt(),
                new Date()));

        return findDepositById(id);
    }

    @Override
    public List<Deposit> listDepositsByUserId(UUID userId) {
        List<Deposit> userDep = new ArrayList();
        for (Deposit dep: DepositTable) {
            if (dep.getUserId().equals(userId))
                userDep.add(dep);
        }
        return userDep;
    }

    @Override
    public Optional<Deposit> findDepositById(UUID id) {

        return DepositTable.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Withdrawal> addWithdrawal(UUID id, Withdrawal withdrawalModel) {

        WithdrawalTable.add(new Withdrawal(id,
                withdrawalModel.getUserId(),
                withdrawalModel.getAmount(),
                withdrawalModel.getDisbursedAt(),
                new Date()));

        return findWithdrawalById(id);
    }

    @Override
    public Optional<Withdrawal> listWithdrawalByUserId(UUID userId) {
        return Optional.empty();
    }

    @Override
    public Optional<Withdrawal> findWithdrawalById(UUID id) {

        return WithdrawalTable.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    @Override
    public void createPaymentTransaction(UUID id, PaymentTransaction payment) {
        PaymentTransactionTable.add(new PaymentTransaction(id,
                payment.getUserId(),
                payment.getAmount(),
                payment.getPaymentType(),
                new Date(),
                payment.getOwnerBalance()));
    }

    @Override
    public List<PaymentTransaction> listPaymentById(UUID userId) {
        List<PaymentTransaction> listPayment = new ArrayList<>();
        for (PaymentTransaction payment: PaymentTransactionTable) {
            if (payment.getUserId().equals(userId))
                listPayment.add(payment);
        }
        return listPayment;
    }

    @Override
    public Optional<Balance> findUserBalanceByUserId(UUID userId) {

        return BalanceTable.stream()
                .filter(x -> x.getUserId()
                .equals(userId)).findFirst();
    }

    @Override
    public void AddUserBalance(UUID userId, Balance balanceModel) {
        BalanceTable.add(new Balance(balanceModel.getId(),
                userId,
                balanceModel.getActualBalance(),
                balanceModel.getAvailableBalance(),
                new Date()));

    }

    @Override
    public void UpdateUserBalance(UUID userId, Balance balanceModel) {
        int index = BalanceTable.indexOf(findUserBalanceByUserId(userId));
        BalanceTable.set(index, balanceModel);
    }
}
