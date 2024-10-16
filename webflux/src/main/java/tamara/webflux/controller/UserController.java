package tamara.webflux.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tamara.webflux.model.request.UserRequest;
import tamara.webflux.model.response.UserResponse;

public interface UserController {

    @PostMapping
    ResponseEntity<Mono<Void>> save(@RequestBody UserRequest request);

    @GetMapping(value = "/{id}")
    RequestEntity<Mono<UserResponse>> find(@PathVariable String id);

    @GetMapping
    RequestEntity<Flux<UserResponse>> findAll();

    @PatchMapping(value = "/{id}")
    RequestEntity<Mono<UserResponse>> update (@PathVariable String id, @RequestBody UserRequest request);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Mono<Void>> delete (@PathVariable String id);
}
