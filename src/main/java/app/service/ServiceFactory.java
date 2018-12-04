package app.service;

public class ServiceFactory {

    public static <T> T getService(Class<? extends T> serviceClass) {

        try {
            return serviceClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


}
