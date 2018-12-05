package app.controller;


import app.po.Message;
import app.po.User;
import app.service.ServiceManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userId}")
    public User getUser(@PathVariable(value = "userId", required = false) Integer userId) {

        ServiceManager.getInstance().getUserService().test();

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


}
