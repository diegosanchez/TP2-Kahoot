package edu.fiuba.algo3;

public class SystemInfo {
    public static String title() {
        return "TP2 KAHOOT";
    }

    public static String course() {
        return "ALGORITMOS Y PROGRAMACION III - FIUBA";
    }

    public static String lista() {
        return "Germán Escandar\n" +
                "Javier Zardai\n" +
                "Santiago Guerra\n" +
                "Miroslav Sapunar\n" +
                "Nicolás De Sousa\n";
    }

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }

    public static String software() {
        return ("java " +javaVersion() + " " + "javafx " + javafxVersion());
    }

}