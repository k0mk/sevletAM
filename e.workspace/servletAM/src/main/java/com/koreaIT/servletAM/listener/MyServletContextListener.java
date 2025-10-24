package com.koreaIT.servletAM.listener; 

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    // 🚨 구현해야 하는 필수 메서드 (비어 있어도 됩니다)
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 웹 애플리케이션 시작 시 로직을 수행합니다.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        // 1. MySQL의 AbandonedConnectionCleanupThread 종료 요청
        try {
            // 현재 프로젝트 버전(checkedShutdown을 사용해야 하는 버전)에 맞게 호출
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown(); 
            System.out.println("MySQL cleanup thread 종료 성공.");
            
        } catch (Exception e) { 
            // 다른 모든 예외 처리
            System.err.println("MySQL cleanup thread 종료 중 알 수 없는 오류 발생: " + e.getMessage());
        }

        // 2. 혹시 모를 JDBC 드라이버 등록 해제
        java.util.Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == sce.getServletContext().getClassLoader()) {
                try {
                    DriverManager.deregisterDriver(driver);
                    System.out.println("JDBC 드라이버 등록 해제 완료: " + driver);
                } catch (SQLException e) {
                    System.err.println("JDBC 드라이버 등록 해제 오류: " + e.getMessage());
                }
            }
        }
    }
}