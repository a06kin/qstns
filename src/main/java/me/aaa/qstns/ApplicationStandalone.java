package me.aaa.qstns;

import static spark.Spark.*;

public class ApplicationStandalone {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
