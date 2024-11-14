package com.azucher;

public class Main {
    private transient Integer age;

    public static void main(String[] args) {
        System.out.println("TaTa");
        String textBlock = """
                "Java Study Guide"
                    by Scott & Jeanne""";
        System.out.println(textBlock);
        Mouse mouse = new Mouse();
        mouse.grow(3);
    }
}