package com.przemek;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Song> playlist = new LinkedList<Song>();

        Album album = new Album("Niemen", "Niemen");
        album.addSong("Dziwny jest ten świat", 5.50);
        album.addSong("Pod papugami", 4.20);
        album.addSong("Sen o Warszawie", 3.55);
        album.addSong("Wspomnienie", 3.22);
        album.addToPlaylist(1, playlist);
        album.addToPlaylist("Wspomnienie", playlist);
        Album album1 = new Album("Helikopter", "Budka Suflera");
        album1.addSong("Sen o dolinie", 3.57);
        album1.addSong("Cień wielkiej góry", 2.51);
        album1.addSong("Jolka, Jolka pamiętasz", 4.01);
        album1.addToPlaylist(3, playlist);

        printActions();
        play(playlist);


    }

    private static void play(LinkedList<Song> playlist) {

     /*   for (Song song:playlist){
            System.out.println(song);
        }*/

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("Play;ist is empty.");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next());
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist completed");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next());
                    } else {
                        System.out.println("This is end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous());
                    } else {
                        System.out.println("This is the beginning of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of playlist.");
                        }
                        }else{
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing: " + listIterator.next());
                                forward = true;
                            } else {
                                System.out.println("We are at the end of playlist.");
                            }
                        }

                    break;
                case 4:
                    print(playlist);
                    break;
                case 5:
                    printActions();
                    break;
                case 6:
                    if (playlist.size()>0){
                        listIterator.remove();
                        break;
                    }

            }

        }

    }

    private static void print(LinkedList<Song> playlist) {
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    private static void printActions() {
        System.out.println("Choose your action\n select:");
        System.out.println("0 - to quit playlist\n" +
                "1 - to play next\n" +
                "2 - to play previous\n" +
                "3 - to replay song\n" +
                "4 - to print whole playlist\n" +
                "5 - to show avible actions\n"+
                "6 - to remove song\n");
    }

}
