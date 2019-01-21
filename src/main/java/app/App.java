package app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

//        b();

//        c();
    }


    public static void c() {

        byte[] hex = {0x00, 0x01, 0x02, 0x03, 0x04};

        System.out.println(String.format("%d", hex[1]));

    }


    public static void b() {

        System.out.println(Integer.toHexString(200));
    }


    public static void a() {
        loop:
        for (; ; ) {
            System.out.println(1);

            for (; ; ) {
                System.out.println(2);
                for (; ; ) {

                    System.out.println(3);

                    for (; ; ) {

                        System.out.println(4);


                        try {
                            Thread.sleep(5000);

                            break loop;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }

                }

            }


        }

    }


}
