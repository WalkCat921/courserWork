package com.egor.zhukovsky.phoneshop.config;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
        private static final String url = "jdbc:postgresql://ec2-34-253-29-48.eu-west-1.compute.amazonaws.com:5432/demia3lvn2e6co?sslmode=require";
        private static final String user = "mtfrbeaavozppl";
        private static final String password = "d3226877d783ab4087b2f89974fc54fce779624c2f9d075edd5ccbb3c518a0ca";
        private static volatile Connection connection;
        private static volatile Config instance;

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                }
            }
        }
        return instance;
    }

    public static Connection getConnection(){
        try {
            if (connection==null){
                connection = DriverManager.getConnection(url,user,password);
            } else {
                System.out.println("Connection not closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if (!connection.isClosed()){
                connection.close();
            } else {
                System.out.println("Connection already closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//            Result<Record> records = create.select().from("test").fetch();
//            for (Record record : records){
//                Integer id = (Integer) record.get("id");
//                String username = (String) record.get("username");
//                System.out.println(id + " " + username);
}
