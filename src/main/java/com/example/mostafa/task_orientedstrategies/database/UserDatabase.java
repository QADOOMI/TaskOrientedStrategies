package com.example.mostafa.task_orientedstrategies.database;


public interface UserDatabase {
    public static final class Table {
        public static final String userTable = "User";

        public static final class Column{
            public static final String firstName = "firstName";
            public static final String lastName = "lastName";
            public static final String email = "email";
            public static final String password = "password";
            public static final String userId = "user_id";

        }
    }
    }


