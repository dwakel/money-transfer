package test.moneytransfer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.moneytransfer.data.IPaymentRepository;
import test.moneytransfer.model.*;
import test.moneytransfer.service.PaymentService;

import java.util.List;
import java.util.UUID;

public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Deposit AddDeposit(@RequestBody Deposit deposit){
        return paymentService.MakeDeposit(deposit);
    }

    @GetMapping(path = "{userId}")
    public List<Deposit> ListDeposit(@PathVariable("userId")UUID userId) {
        return paymentService.ListDeposit(userId);
    }

    public Withdrawal AddWithdrawal(@RequestBody Withdrawal withdrawal){
        return paymentService.MakeWithdrawal(withdrawal);
    }

//    @GetMapping(path = "{userId}")
//    public List<Withdrawal> ListWithdrawal(@PathVariable("userId")UUID userId) {
//
//    }

    @GetMapping(path = "{userId}")
    public List<PaymentTransaction> ListPayments(@PathVariable("userId")UUID userId) {
        return paymentService.ListPayments(userId);
    }

    @GetMapping(path = "{userId}")
    public Balance GetCurrentBalance(@PathVariable("userId")UUID userId) {
    return paymentService.GetBalance(userId);
    }

}
