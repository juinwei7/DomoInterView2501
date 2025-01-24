package com.weiwei.dataBase;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import lombok.Getter;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreatTable {
//    public static HikariDataSource dataSource = null;
//
//    /*
//    DataBase 資料庫連線
//    createTable 建立資料庫
//     */
//    public CreatTable() {
//        String path = "mysql.";
//        String host = dataBase.getString(path + "host");
//        int port = dataBase.getInt(path + "port");
//        String database = dataBase.getString(path + "database");
//        String user = dataBase.getString(path + "user");
//        String password = dataBase.getString(path + "password");
//
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
//        config.setUsername(user);
//        config.setPassword(password);
//        config.setPoolName(database);
//        config.setConnectionTestQuery("SELECT 1;");
//
//        dataSource = new HikariDataSource(config);
//        creatTable();
//    }
//    public static void creatTable() {
//        String[] SQL = new String[]{
//                "CREATE TABLE IF NOT EXISTS `playerInfo` (uuid VARCHAR(36) PRIMARY KEY, name VARCHAR(36));",
//                "CREATE TABLE IF NOT EXISTS `bosstime` (boss_spawner VARCHAR(36) PRIMARY KEY, expiretime INT);",
//                "CREATE TABLE IF NOT EXISTS `taxplayer` (id INT AUTO_INCREMENT PRIMARY KEY, uuid VARCHAR(36), name VARCHAR(36), taxMoney INT, taxRate INT, lastTime TIMESTAMP);",
//                "CREATE TABLE IF NOT EXISTS `chequemoney_new` (identification VARCHAR(36) PRIMARY KEY, creat_name VARCHAR(36), value INT, creat_time TIMESTAMP, use_name VARCHAR(36), use_time TIMESTAMP);",
//                "CREATE TABLE IF NOT EXISTS `chequeexp_new` (identification VARCHAR(36) PRIMARY KEY, creat_name VARCHAR(36), value INT, creat_time TIMESTAMP, use_name VARCHAR(36), use_time TIMESTAMP);",
//                "CREATE TABLE IF NOT EXISTS `chequehub_new` (identification VARCHAR(36) PRIMARY KEY, creat_name VARCHAR(36), value INT, creat_time TIMESTAMP, use_name VARCHAR(36), use_time TIMESTAMP);",
//        };
//        try (Connection connection = dataSource.getConnection()) {
//            for (String sqlLine : SQL) {
//                PreparedStatement statement = connection.prepareStatement(sqlLine);
//                statement.executeUpdate();
//            }
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//    }
//
//    @Getter
//    private static YamlConfiguration dataBase;
//
//
//    public static void loadConfig() {
//        File file = new File(CreatTable.class.getClassLoader().getResource("DataBase.yml").getFile());
//        dataBase = YamlConfiguration.loadConfiguration(file);
//        dataBase = YamlConfiguration.loadConfiguration(file);
//    }

}
