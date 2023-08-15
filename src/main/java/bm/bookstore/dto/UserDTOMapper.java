package bm.bookstore.dto;

import bm.bookstore.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOMapper implements Function<UserEntity, UserDTO> {
    @Override
    public UserDTO apply(UserEntity bookEntity) {
        return UserDTO.from(bookEntity);
    }
}

