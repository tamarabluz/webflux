package tamara.webflux.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tamara.webflux.entity.User;
import tamara.webflux.mapper.UserMapper;
import tamara.webflux.model.request.UserRequest;
import tamara.webflux.repository.UserRepository;
import tamara.webflux.service.exception.ObjectNotFoundException;

import java.text.Format;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class Userservice {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save (final UserRequest request){
        return repository.save(mapper.toEntity(request));
    }

    public Mono<User> findById( final String id){
        return repository.findById(id)
                .switchIfEmpty(Mono.error(
                        new ObjectNotFoundException(
                                format("Object not found")
                        )
                ));
    }
}
