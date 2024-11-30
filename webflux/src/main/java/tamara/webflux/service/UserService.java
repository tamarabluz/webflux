package tamara.webflux.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tamara.webflux.entity.User;
import tamara.webflux.mapper.UserMapper;
import tamara.webflux.model.request.UserRequest;
import tamara.webflux.repository.UserRepository;
import tamara.webflux.service.exception.ObjectNotFoundException;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save (final UserRequest request){
        return repository.save(mapper.toEntity(request));
    }

    public Mono<User> findById( final String id){
        return handleNotFount(repository.findById(id), id);
    }

    public Flux<User> findAll(){
        return repository.findAll();
    }

    public Mono<User> update(final String id, final UserRequest request){
        return findById(id)
                .map(entity -> mapper.toEntity(request, entity))
                .flatMap(repository::save);
    }

    public Mono<User> delete(final String id){
        return handleNotFount(repository.findAndRemove(id), id);
    }

    private <T> Mono<T> handleNotFount(Mono<T> mono, String id){
        return mono.switchIfEmpty(Mono.error(
                new ObjectNotFoundException(
                        format("Object not found")
                )
        ));
    }
}
