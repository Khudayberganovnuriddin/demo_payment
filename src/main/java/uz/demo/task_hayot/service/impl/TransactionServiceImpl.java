package uz.demo.task_hayot.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.demo.task_hayot.converter.response.TransactionResponseConverter;
import uz.demo.task_hayot.dto.base.IdResponse;
import uz.demo.task_hayot.dto.transaction.criteria.TransactionCriteria;
import uz.demo.task_hayot.dto.transaction.request.TransactionCreateRequest;
import uz.demo.task_hayot.dto.transaction.response.TransactionResponse;
import uz.demo.task_hayot.entity.Transaction;
import uz.demo.task_hayot.entity.User;
import uz.demo.task_hayot.enums.OperationType;
import uz.demo.task_hayot.enums.TransactionStatus;
import uz.demo.task_hayot.repository.TransactionRepository;
import uz.demo.task_hayot.repository.UserRepository;
import uz.demo.task_hayot.repository.criteria.TransactionCriteriaRepository;
import uz.demo.task_hayot.service.contract.TransactionService;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:27
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionServiceImpl implements TransactionService {

  TransactionRepository repository;
  TransactionCriteriaRepository criteriaRepository;
  TransactionResponseConverter converter;
  UserRepository userRepository;

  @Override
  public List<TransactionResponse> retrieveTransactions(TransactionCriteria criteria) {
    List<Transaction> transactions = criteriaRepository.retrieveTransactions(criteria);
    return transactions.stream().map(converter::from).toList();
  }

  @Transactional
  @Override
  public IdResponse create(TransactionCreateRequest request) {
    Optional<User> userOptional = userRepository.findById(request.userId());
    if (userOptional.isEmpty()){
      throw new RuntimeException("User not found with id: " + request.userId());
    }
    User user = userOptional.get();
    if (user.getBalance() < request.amount()){
      throw new RuntimeException("User balance is not enough");
    }

    Transaction transaction = new Transaction();
    transaction.setOperationType(OperationType.PAYMENT);
    transaction.setUserId(user.getId());
    transaction.setServiceId(request.serviceId());
    transaction.setTransactionAmount(request.amount());
    transaction.setTransactionCurrency(request.currency());
    transaction.setStatus(TransactionStatus.NEW);
    transaction.setPerformedAt(LocalDateTime.now());
    Transaction saved = repository.save(transaction);

    user.setBalance(user.getBalance() - request.amount());
    userRepository.save(user);

    return new IdResponse(saved.getId());
  }
}
