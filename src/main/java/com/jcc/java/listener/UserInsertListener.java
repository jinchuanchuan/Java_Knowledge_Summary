package com.jcc.java.listener;

import com.alibaba.fastjson.JSON;
import com.jcc.java.temp.User;
import org.springframework.context.ApplicationListener;

public class UserInsertListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        String source = (String)userRegisterEvent.getSource();
        User user = JSON.parseObject(source, User.class);
    }
}
