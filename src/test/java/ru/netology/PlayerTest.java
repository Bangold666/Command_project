package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game,3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты

    @Test
    public void shouldSumGenreIfReplaySameGame(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game,6);
        player.play(game,3);

        int expected = 9;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnHoursIfPlayOneTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);

        int actual = player.play(game, 3);
        int expected = 3;
        assertEquals(expected, actual);
    }
    
     @Test
    public void shouldFindMostPlayedGameByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Петька и Василий Иванович", "Квест");
        Game game3 = store.publishGame("Аллоды", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 10);
        player.play(game3, 2);
        Game actual1 = player.mostPlayerByGenre(game2.getGenre());
        Game expected1 = game2;
        Game actual2 = player.mostPlayerByGenre(game3.getGenre());
        Game expected2 = game1;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
    
    @Test
    public void shouldThrowException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        assertThrows(RuntimeException.class, () -> {
            player.play(game, 3);
        });
    }
}
