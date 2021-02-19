package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;


class LocalizationServiceImplTest {
     LocalizationServiceImpl localizationService;

    @BeforeEach
     void before() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    void test_locate_greeting_RUSSIA() {
        //given
        Country country = Country.RUSSIA;
        String expected = "Добро пожаловать";

        //when
        String result = localizationService.locale(country);

        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_locate_greeting_USA() {
        //given
        Country country = Country.USA;
        String expected = "Welcome";

        //when
        String result = localizationService.locale(country);

        //then
        Assertions.assertEquals(expected, result);
    }

}