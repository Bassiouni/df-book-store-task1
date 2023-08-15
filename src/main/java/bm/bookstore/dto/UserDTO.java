package bm.bookstore.dto;

import bm.bookstore.entities.UserEntity;

public record UserDTO(int id, String username) {
    public static UserDTO from(UserEntity bookEntity) {
        return new UserDTO(bookEntity.getId(), bookEntity.getUsername());
    }
}
