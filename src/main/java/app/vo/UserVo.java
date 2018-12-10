package app.vo;

import app.po.BaseBean;
import app.po.User;

import java.util.List;

public class UserVo extends BaseBean {

    public User user;

    public List<User> users;

    public static UserVo newInstance() {

        return new UserVo();
    }


}
