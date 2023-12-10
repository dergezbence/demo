package com.example.demo;

import com.example.demo.entity.PersonEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PersonRepository;
import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

  private final DemoService demoService;
  private final PersonRepository personRepository;

  @GetMapping("/demo")
  public DeferredResult<String> demo() {
    DeferredResult<String> result = new DeferredResult<>();
    new Thread(() -> {
      try {
        Thread.sleep(4000);
        result.setResult("Hello world");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }).start();

    log.info("Processing finished");
    return result;
  }

  @GetMapping("/demo2")
  public DeferredResult<String> demo2() {
    DeferredResult<String> result = new DeferredResult<>();

    Observable<String> observable = Observable.fromCallable(demoService::longRunningProcess);

    observable.subscribe(result::setResult, result::setErrorResult);
    log.info("Processing finished");
    return result;
  }

  @PostMapping("/person")
  public String demoPost(@RequestBody PersonEntity personEntity) {
    personRepository.save(personEntity);
    return "OK";
  }

  @GetMapping("/person/{id}")
  public PersonEntity demoPost(@PathVariable("id") Long personId) {
    return personRepository.findById(personId).orElseThrow(NotFoundException::new);
  }
}
