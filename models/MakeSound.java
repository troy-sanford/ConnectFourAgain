package models;

/*
    last edited: 04/30/19
    author: Troy Sanford
    purpose: Connects to API to play sound when tile is dropped
*/

public class MakeSound {

    // call an external API to make a *clink* sound effect
    public static void playClink() {
        System.out.println("*clink*");
    }

    // call an external API to make a sound effect representing victory
    public static void playVictory() {
        System.out.println("* hooty hoo *");
    }

}
