package com.example.joketeller;

public class Jokes {

    public static String[] Jokes = {
            "Anton, do you think I am a bad mother? My name is Paul.",
            "Can a kangaroo jump higher than a house? Of course, a house does not jump at all.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "What is the difference between a snowman and a snowwoman? Snowballs."};

    public static void setJokes(String[] jokes) {
        Jokes = jokes;
    }

    private static int joke = 0;

    public static String getNextJoke() {
        if (joke == Jokes.length)
            joke = 0;

        return Jokes[joke++];
    }
}
