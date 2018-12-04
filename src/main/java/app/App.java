package app;


import app.service.ServiceManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ServiceManager.INSTANCE.getUserService().test();

//        SpringApplication.run(App.class, args);

    }

}
