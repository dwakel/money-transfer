package test.moneytransfer.data;

import test.moneytransfer.model.Balance;
import test.moneytransfer.model.Deposit;
import test.moneytransfer.model.PaymentTransaction;
import test.moneytransfer.model.Withdrawal;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPaymentRepository {
    //Make a deposit
    Optional<Deposit> addDeposit(UUID id, Deposit depositModel);

    //List Deposits
    List<Deposit> listDepositsByUserId(UUID userId);

    //Find Deposits by deposit id
    Optional<Deposit> findDepositById(UUID id);

    //Make a deposit
    Optional<Withdrawal> addWithdrawal(UUID id, Withdrawal depositModel);

    //List withdrawal
    Optional<Withdrawal> listWithdrawalByUserId(UUID userId);

    //Find Withdrawal by withdrawal id
    Optional<Withdrawal> findWithdrawalById(UUID id);

    //Payment transaction
    void createPaymentTransaction(UUID id, PaymentTransaction payment);

    //List Payment Transaction by user id
    List<PaymentTransaction> listPaymentById(UUID userId);

    //Get customer balance
    Optional<Balance> findUserBalanceByUserId(UUID userId);

    //Create customer balance
    void AddUserBalance(UUID userId, Balance balanceModel);

    void UpdateUserBalance(UUID userId, Balance balanceModel);





}
