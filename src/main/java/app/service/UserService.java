package app.service;

public enum UserService implements IUserService {

    INSTANCE {
        @Override
        public void test() {

            System.out.println("test!!!!!!!!!!!!!!!!!!!!");

        }
    }

}
