package rs.engineering.javacourse.myspringmvcapp.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.cj.log.Log;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	Enumeration<Driver> drivers = DriverManager.getDrivers();
    	while (drivers.hasMoreElements()) {
    	    Driver driver = drivers.nextElement();
    	    try {
    	        DriverManager.deregisterDriver(driver);
//    	        Log.log(Level.INFO, String.format("deregistering jdbc driver: %s", driver));
    	    } catch (SQLException e) {
//    	        Log.log(Level.SEVERE, String.format("Error deregistering driver %s", driver), e);
    	    }
    	}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
