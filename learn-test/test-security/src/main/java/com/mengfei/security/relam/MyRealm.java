package com.mengfei.security.relam;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Menufunctionlist;
import com.mengfei.security.pojo.Rolepriinfo;
import com.mengfei.security.service.MenufunctionlistService;
import com.mengfei.security.service.RolepriinfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private RolepriinfoService rolepriinfoService;

    @Autowired
    private MenufunctionlistService menufunctionlistService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Set<Long> set = new HashSet<>();
        set.add(3l);
        ReturnMessage<Rolepriinfo> funcList = rolepriinfoService.findByMenuidInAndFuncidNot(set, 0);
        Set<String> buttonSet = new HashSet<>();
        for (Rolepriinfo rolepriinfo : funcList.getList()) {
            ReturnMessage<Menufunctionlist> byMenuid = menufunctionlistService.findByMenuid(rolepriinfo.getMenuid());
            Menufunctionlist object = byMenuid.getObject();

            buttonSet.add(object.getFuncurl());
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(buttonSet);

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
