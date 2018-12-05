package app.service;

public enum ServiceManager implements IServiceManager {

    INSTANCE {
        @Override
        public IUserService getUserService() {

            return UserService.INSTANCE;
        }
    };

    public static ServiceManager getInstance() {
        return INSTANCE;
    }

}
