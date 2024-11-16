package tamara.webflux.mapper;
import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tamara.webflux.entity.User;
import tamara.webflux.model.request.UserRequest;
import tamara.webflux.model.response.UserResponse;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS)
public interface UserMapper {
    @Mapping(target= "id", ignore= true)
    User toEntity(final UserRequest request);

    UserResponse toResponse(final User entity);
}
