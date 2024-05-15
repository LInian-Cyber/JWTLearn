package org.scheele.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello(){
        return "hello";
    }


    /***hasAnyAuthority方法可以传入多个权限，只有用户有其中任意一个权限都可以访问对应资源。
    hasRole要求有对应的角色才可以访问，但是它内部会把我们传入的参数拼接上 ROLE_ 后再去比较。所
    以这种情况下要用用户对应的权限也要有 ROLE_ 这个前缀才可以。
    hasAnyRole 有任意的角色就可以访问。它内部也会把我们传入的参数拼接上 ROLE_ 后再去比较。所以
    这种情况下要用用户对应的权限也要有 ROLE_ 这个前缀才可以。
    自定义权限校验方法
    我们也可以定义自己的权限校验方法，在@PreAuthorize注解中使用我们的方法。
    @PreAuthorize("hasAnyAuthority('admin','test','system:dept:list')")
    public String hello(){
        return "hello";
    }
    @PreAuthorize("hasRole('system:dept:list')")
    public String hello(){
        return "hello";
    }
    @PreAuthorize("hasAnyRole('admin','system:dept:list')")
    public String hello(){
        return "hello";
    }***/
}
