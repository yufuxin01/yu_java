package com.yu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname UserRoleAuthorizationInterceptor
 * @Date 2021/2/18 12:24
 * @Created by yufx
 */
public class UserRoleAuthorizationInterceptor extends HandlerInterceptorAdapter {
    // 字符串数组，用来存放用户角色信息
    private String[] authorizedRoles;

    public final void setAuthorizedRoles(String[] authorizedRoles) {
        this.authorizedRoles = authorizedRoles;
    }

    public final boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {
        if (this.authorizedRoles != null) {
            for (int i = 0; i < this.authorizedRoles.length; ++i) {
                if (request.isUserInRole(this.authorizedRoles[i])) {
                    return true;
                }
            }
        }
        handleNotAuthorized(request, response, handler);
        return false;
    }

    protected void handleNotAuthorized(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {
        // 403表示资源不可用。服务器理解用户的请求，但是拒绝处理它，通常是由于权限的问题
        response.sendError(403);
    }
}
