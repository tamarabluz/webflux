package tamara.webflux.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tamara.webflux.controller.UserController;
import tamara.webflux.model.request.UserRequest;
import tamara.webflux.model.response.UserResponse;
import tamara.webflux.service.Userservice;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final Userservice service;

    @Override
    public ResponseEntity<Mono<Void>> save(UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(request).then());
    }

    @Override
    public RequestEntity<Mono<UserResponse>> find(String id) {
        return null;
    }

    @Override
    public RequestEntity<Flux<UserResponse>> findAll() {
        return null;
    }

    @Override
    public RequestEntity<Mono<UserResponse>> update(String id, UserRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Mono<Void>> delete(String id) {
        return null;
    }
}
