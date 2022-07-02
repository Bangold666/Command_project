package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContainGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        boolean actual = store.containsGame(game);
        boolean expected = true;
        assertEquals(actual, expected);

    }

    @Test
    public void shouldAddPlayTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Вася", 3);
        int actual = store.getPlayedTime("Вася");
        int expected = 3;
        assertEquals(actual, expected);
    }


}
