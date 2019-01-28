package com.app;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high-level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        System.out.println(languages.put("Algol", "a family of algorithmic languages"));
        System.out.println(languages.put("BASIC", "Beginners All Purpose Symbolic Instruction Code"));
        languages.put("Lisp", "another programming language");

        // System.out.println(languages.put("Java", "this course is about Java")); // this would print previous entry

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        // languages.remove("Lisp");

        if (languages.remove("Algol", "a family of algorithmic languages")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed.  Key/value pair not found");
        }

        System.out.println("=================================");

        if (languages.replace("Lisp", "another programming language", "a functional programming language")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp is not replaced");
        }
        languages.replace("Scala", "this will not be added");

        for (String key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
