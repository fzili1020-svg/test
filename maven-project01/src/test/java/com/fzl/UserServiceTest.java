package com.fzl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void getAge_ValidIdCard_CorrectAge() {
        // 假设当前年份是2023年
        // 2000年10月1日出生，应为23岁
        String idCard = "100000200010011011";
        Integer age = userService.getAge(idCard);
        assertEquals(24, age);
    }

    @Test
    public void getAge_NullIdCard_ThrowsException() {
        Executable executable = () -> userService.getAge(null);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void getAge_InvalidIdCardLength_ThrowsException() {
        String idCard = "10000020001001101"; // 17位
        Executable executable = () -> userService.getAge(idCard);
        assertThrows(IllegalArgumentException.class, executable);
    }
    @Test
    public void getGender_ValidMaleIdCard_ReturnsMale() {
        String idCard = "100000200010011011"; // 第17位是1，奇数
        String gender = userService.getGender(idCard);
        assertEquals("男", gender);
    }

    @Test
    public void getGender_ValidFemaleIdCard_ReturnsFemale() {
        String idCard = "100000200010011021"; // 第17位是2，偶数
        String gender = userService.getGender(idCard);
        assertEquals("女", gender);
    }

    @Test
    public void getGender_NullIdCard_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> userService.getGender(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000020001001101", "1000002000100110111", ""})
    public void getGender_InvalidIdCardLength_ThrowsException(String idCard) {
        assertThrows(IllegalArgumentException.class, () -> userService.getGender(idCard));
    }
}
