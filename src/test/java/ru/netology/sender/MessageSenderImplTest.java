package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {
    GeoServiceImpl geoService;
    LocalizationServiceImpl localizationService;
    MessageSenderImpl messageSender;
    Map<String, String> headers;

    @BeforeEach
    void before() {
        geoService = Mockito.mock(GeoServiceImpl.class);
        localizationService = Mockito.mock(LocalizationServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
        headers = new HashMap<String, String>();
    }

    @Test
    public void test_send_MOSCOW_IP_RUSSIA_full() {
        //given
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        String expected = "Добро пожаловать";

        //when
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String result = messageSender.send(headers);

        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_send_NEW_YORK_IP_USA_full() {
        //given
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        String expected = "Welcome";

        //when
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String result = messageSender.send(headers);

        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    void test_send_MOSCOW_IP_RUSSIA() {
        //given
        Mockito.when(geoService.byIp("172.45.33.55")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        String expected = "Добро пожаловать";

        //when
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.45.33.55");
        String result = messageSender.send(headers);

        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_send_NEW_YORK_IP_USA() {
        //given
        Mockito.when(geoService.byIp("96.88.322.129")).thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        String expected = "Welcome";

        //when
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.88.322.129");
        String result = messageSender.send(headers);

        //then
        Assertions.assertEquals(expected, result);
    }
}