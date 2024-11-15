package com.agcodes.customer.utils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5433/customer";
    String username = "test";
    String password = "password";

    DriverManager.setLogWriter(new PrintWriter(System.out));

    try (Connection connection = DriverManager.getConnection(url, username, password)) {

      System.out.println("Connection successful!");
    } catch (Exception e) {
      System.err.println("Failed to connect to the database.");
      e.printStackTrace();
    }

  }
}
