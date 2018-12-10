package app.controller;


import app.po.Message;
import app.po.User;
import app.vo.UserVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userId}")
    public User getUser(@PathVariable(value = "userId", required = false) Integer userId) {

        final User user = User.newInstance();

        if (Objects.nonNull(userId)) {

            user.setUserId(new Random().nextInt(Integer.MAX_VALUE));

            user.setAddress("address");

            user.setAge(100);

            user.setGender(0);

            user.setName("zero");

            return user;

        } else {

            user.setCode(Message.FAIL_PARAM_NULL);

            user.setMsg("userId不能为空！！！");

            return user;
        }


    }


    @RequestMapping("list/{page}")
    public UserVo getUserList(@PathVariable(value = "page") int page) {

        if (page <= 0) page = 1;

        final UserVo vo = UserVo.newInstance();

        if (page > 10) {

            vo.setCode(0);
            vo.setMsg("没有更多数据");

            return vo;
        }

        final List<User> userList = new ArrayList<>();

        for (int i = (page - 1) * 20; i < page * 20; i++) {

            final User user = User.newInstance();

            user.setUserId(new Random().nextInt(Integer.MAX_VALUE));

            user.setAddress("address");

            user.setAge(new Random().nextInt(150));

            user.setGender(new Random().nextInt(2));

            user.setName("user" + (i + 1));

            userList.add(user);

        }

        vo.users = userList;

        return vo;

    }


}
