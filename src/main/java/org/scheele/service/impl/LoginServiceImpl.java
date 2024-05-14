package org.scheele.service.impl;

import org.scheele.config.JwtUtil;
import org.scheele.config.RedisCache;
import org.scheele.config.ResponseResult;
import org.scheele.domain.LoginUser;
import org.scheele.domain.User;
import org.scheele.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginServcie {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authentication)){
            throw new RuntimeException("用户名或者密码错误");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        redisCache.setCacheObject("login:"+userid,loginUser);
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override
    public ResponseResult logout() {
        return null;
    }
}
