package test.moneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import test.moneytransfer.data.IPaymentRepository;
import test.moneytransfer.model.*;

import java.util.List;
import java.util.UUID;

public class PaymentService {
    private final IPaymentRepository paymentRepository;

    @Autowired
    public PaymentService(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Deposit MakeDeposit(Deposit deposit){
        Deposit dep = paymentRepository.addDeposit(UUID.randomUUID(), deposit)
                .orElse(null);
        UUID newId = UUID.randomUUID();
        Balance balance = paymentRepository.findUserBalanceByUserId(dep.getUserId()).orElse(null);

        if (balance == null){
            paymentRepository.AddUserBalance(UUID.randomUUID(), new Balance(
                    null,
                    dep.getUserId(),
                    dep.getAmount(),
                    dep.getAmount(),
                    dep.getPaidAt()));
        }
        else {
            paymentRepository.UpdateUserBalance(UUID.randomUUID(), new Balance(
                    null,
                    dep.getUserId(),
                    balance.getActualBalance() + dep.getAmount(),
                    balance.getAvailableBalance() + dep.getAmount(),
                    dep.getPaidAt()));
        }
        balance = paymentRepository.findUserBalanceByUserId(dep.getUserId()).orElse(null);

        paymentRepository.createPaymentTransaction(newId,
                new PaymentTransaction(newId,
                        dep.getUserId(),
                        dep.getAmount(),
                        PaymentType.deposit,
                        dep.getPaidAt(),
                        balance.getActualBalance()));
        return dep;
    }

    public List<Deposit> ListDeposit(UUID userId){
        return paymentRepository.listDepositsByUserId(userId);
    }


    public Withdrawal MakeWithdrawal(Withdrawal withdrawal){
        Withdrawal wit = paymentRepository.addWithdrawal(UUID.randomUUID(), withdrawal)
                .orElse(null);
        UUID newId = UUID.randomUUID();
        Balance balance = paymentRepository.findUserBalanceByUserId(wit.getUserId()).orElse(null);

        if (balance == null){
            paymentRepository.AddUserBalance(UUID.randomUUID(), new Balance(
                    null,
                    wit.getUserId(),
                    wit.getAmount(),
                    wit.getAmount(),
                    wit.getDisbursedAt()));
        }
        else {
            paymentRepository.UpdateUserBalance(UUID.randomUUID(), new Balance(
                    null,
                    wit.getUserId(),
                    balance.getActualBalance() - wit.getAmount(),
                    balance.getAvailableBalance() - wit.getAmount(),
                    wit.getDisbursedAt()));
        }
        balance = paymentRepository.findUserBalanceByUserId(wit.getUserId()).orElse(null);

        paymentRepository.createPaymentTransaction(newId,
                new PaymentTransaction(newId,
                        wit.getUserId(),
                        wit.getAmount(),
                        PaymentType.withdrawal,
                        wit.getDisbursedAt(),
                        balance.getActualBalance()));
        return wit;
    }

    public List<PaymentTransaction> ListPayments(UUID userId){
        return paymentRepository.listPaymentById(userId);
    }

    public Balance GetBalance(UUID userId){
        return paymentRepository.findUserBalanceByUserId(userId).orElse(null);
    }

//    public List<Withdrawal> ListWithdrawal(UUID userId){
//        return paymentRepository.listWithdrawalByUserId(userId);
//    }

}
