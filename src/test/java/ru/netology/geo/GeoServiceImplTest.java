package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


class GeoServiceImplTest {
    GeoServiceImpl geoService;

    @BeforeEach
    void before() {
        geoService = new GeoServiceImpl();
    }

    @Test
    void test_Location_byIp_MOSCOW_RUSSIA_full() {
        //given
        String ip = "172.0.32.11";
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        //when
        Location result = geoService.byIp(ip);

        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    void test_Location_byIp_MOSCOW_RUSSIA() {
        //given
        String ip = "172.56.76.99";
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);

        //when
        Location result = geoService.byIp(ip);

        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    void test_Location_byIp_NEW_YORK_USA_full() {
        //given
        String ip = "96.44.183.149";
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);

        //when
        Location result = geoService.byIp(ip);

        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    void test_Location_byIp_NEW_YORK_USA() {
        //given
        String ip = "96.55.213.12";
        Location expected = new Location("New York", Country.USA, null, 0);

        //when
        Location result = geoService.byIp(ip);

        //then
        Assertions.assertEquals(expected, result);

    }

}