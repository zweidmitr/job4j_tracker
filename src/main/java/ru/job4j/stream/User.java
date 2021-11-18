package ru.job4j.stream;

public class User {
    private String name;
    private String surName;
    private byte age;

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", surName='" + surName + '\''
                + ", age=" + age
                + '}';
    }

    static class Builder {
        private String name;
        private String surName;
        private byte age;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurName(String surName) {
            this.surName = surName;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        User build() {
            User user = new User();
            user.name = name;
            user.surName = surName;
            user.age = age;
            return user;
        }
    }

    public static void main(String[] args) {
        User user = new Builder()
                .buildName("name")
                .buildSurName("surname")
                .buildAge((byte) 32)
                .build();
        System.out.println(user);
    }
}
