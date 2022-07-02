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
//        int actual = store.getPlayedTime("Вася");
        int expected = 3;
//        assertEquals(actual, expected);
    }

    @Test
    public void shouldGetMostPlayerWhenThreePlayers() {
        GameStore store = new GameStore();
        store.addPlayTime("Вася", 1);
        store.addPlayTime("Петя", 4);
        store.addPlayTime("Саша", 5);
        String actual = store.getMostPlayer();
        String expected = "Саша";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerWhenOneHourPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Вася", 1);
        String actual = store.getMostPlayer();
        String expected = "Вася";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerWhenNoPlayers() {
        GameStore store = new GameStore();
        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Вася", 5);
        store.addPlayTime("Петя", 1);
        store.addPlayTime("Саша", 4);
        int actual = store.getSumPlayedTime();
        int expected = 10;
        assertEquals(expected, actual);

    }
}
