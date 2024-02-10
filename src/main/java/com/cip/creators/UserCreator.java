package com.cip.creators;

import com.cip.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Klasa przechowująca DTO (Data Transfer Object) dla klasy {@link com.cip.entity.UserEntity}, służąca do tworzenia użytkownika.
 */
@AllArgsConstructor
@Getter
public class UserCreator {
    /**
     * Zmienna typu String przechowująca adres mailowy użytkownika.
     */
    private String email;
    /**
     * Zmienna typu String przechowująca login pacjenta.
     */
    private String login;
    /**
     * Zmienna typu String przechowująca hasło pacjenta.
     */
    private String password;
    /**
     * Zmienna typu {@link RoleEnum} przechowująca role użytkownika.
     */
    private RoleEnum role;
}