package ru.netology.smart_home;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest()
    @CsvSource({
            "Middle station, 5, 6",
            "Last station, 9, 0"
    })
    void shouldSetNextStation(String name, int station, int expected) {
        radio.setCurrentStation(station); // Выставляем текущую станцию
        radio.nextStation(); // Переключаем на следующую станцию
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Middle station, 5, 4",
            "First station, 0, 9"
    })
    void shouldSetPrevStation(String name, int station, int expected) {
        radio.setCurrentStation(station); // Выставляем текущую станцию
        radio.prevStation(); // Переключаем на предыдущую станцию
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Middle station, 5, 5",
            "First station, 0, 0",
            "Last station, 9, 9",
            "Below Limit, -1, 0",
            "Over Limit, 10, 0",
    })
    void shouldSetStation(String name, int station, int expected) {
        radio.setCurrentStation(station); // Переключаем на желаемую станцию
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Normal volume, 5, 6",
            "Maximum volume, 10, 10"
    })
    void shouldIncreaseVolume(String name, int volume, int expected) {
        radio.setCurrentVolume(volume); // Выставляем текущую громкость
        radio.increaseVolume(); // Прибавляем громкость
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Normal volume, 5, 4",
            "Minimum volume, 0, 0"
    })
    void shouldDecreaseVolume(String name, int volume, int expected) {
        radio.setCurrentVolume(volume); // Выставляем текущую громкость
        radio.decreaseVolume(); // Убавляем громкость
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvSource({
            "Normal volume, 5, 5",
            "Minimum volume, 0, 0",
            "Maximum volume, 10, 10",
            "Below Limit, -1, 0",
            "Over Limit, 11, 0",
    })
    void shouldSetCurrentVolume(String name, int volume, int expected) {
        radio.setCurrentVolume(volume); // Переключаем на желаемую станцию
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }
}
