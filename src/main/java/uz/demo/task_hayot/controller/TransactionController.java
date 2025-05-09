package uz.demo.task_hayot.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.demo.task_hayot.dto.base.IdResponse;
import uz.demo.task_hayot.dto.base.Response;
import uz.demo.task_hayot.dto.transaction.criteria.TransactionCriteria;
import uz.demo.task_hayot.dto.transaction.request.TransactionCreateRequest;
import uz.demo.task_hayot.dto.transaction.response.TransactionResponse;
import uz.demo.task_hayot.service.contract.TransactionService;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:26
 */
@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionController {

  TransactionService transactionService;

  @PostMapping("/search")
  public Response<List<TransactionResponse>> getTransactions(@RequestBody TransactionCriteria criteria) {
    return new Response<>(transactionService.retrieveTransactions(criteria));
  }

  @PostMapping
  public Response<IdResponse> create(@RequestBody TransactionCreateRequest request) {
    return new Response<>(transactionService.create(request));
  }
}
