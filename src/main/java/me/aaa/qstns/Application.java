package me.aaa.qstns;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
