package org.scheele.service;

import org.scheele.config.ResponseResult;
import org.scheele.domain.User;

public interface LoginServcie {
    ResponseResult login(User user);

    ResponseResult logout();

}
