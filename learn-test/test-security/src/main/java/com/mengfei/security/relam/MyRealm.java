package com.mengfei.security.relam;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Hostinfo;
import com.mengfei.security.pojo.Menufunctionlist;
import com.mengfei.security.pojo.Rolepriinfo;
import com.mengfei.security.pojo.Rolestore;
import com.mengfei.security.service.HostinfoService;
import com.mengfei.security.service.MenufunctionlistService;
import com.mengfei.security.service.RolepriinfoService;
import com.mengfei.security.service.RolestoreService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private HostinfoService hostinfoService;

    @Autowired
    private RolestoreService rolestoreService;

    @Autowired
    private RolepriinfoService rolepriinfoService;

    @Autowired
    private MenufunctionlistService menufunctionlistService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Hostinfo user = (Hostinfo)principalCollection.getPrimaryPrincipal();
        Long userId = user.getId();

        //通过userID获取角色
        ReturnMessage<Rolestore> byHostshopid = rolestoreService.findByHostshopid(userId);
        List<Rolestore> list = byHostshopid.getList();
        Set<Long> roles = new HashSet<>();
        for(Rolestore rolestore : list){
            roles.add(rolestore.getRoleid());
        }

        //通过角色来获取一级menu
        /*ReturnMessage<Rolepriinfo> byRoleIdSet = rolepriinfoService.findByRoleIdSet(roles, 0);
        List<Rolepriinfo> list1 = byRoleIdSet.getList();
        Set<Long> set = new HashSet<>();
        //set.add(3l);
        for (Rolepriinfo rolepriinfo : list1) {
            set.add(rolepriinfo.getMenuid());
        }

        //通过一级menu来获取二级menu
        ReturnMessage<Rolepriinfo> funcList = rolepriinfoService.findByMenuidInAndFuncidNot(set, 0);
        Set<String> buttonSet = new HashSet<>();
        for (Rolepriinfo rolepriinfo : funcList.getList()) {

            //通过二级menu来获取button列表
            ReturnMessage<Menufunctionlist> byMenuid = menufunctionlistService.findByMenuid(rolepriinfo.getMenuid());
            Menufunctionlist object = byMenuid.getObject();

            buttonSet.add(object.getFuncurl());
        }*/

        //通过角色查询到所有的button权限
        ReturnMessage<Rolepriinfo> byRoleIdSet = rolepriinfoService.findByRoleIdSet(roles);
        List<Rolepriinfo> list2 = byRoleIdSet.getList();
        Set<Long> buttonSet = new HashSet<>();
        for (Rolepriinfo rolepriinfo : list2) {
            buttonSet.add(rolepriinfo.getFuncid());
        }

        //通过buttonID查询所有的button url
        ReturnMessage<Menufunctionlist> byFuncids = menufunctionlistService.findByFuncids(buttonSet);
        Set<String> urlSet = new HashSet<>();
        for(Menufunctionlist menufunctionlist : byFuncids.getList()){
            urlSet.add(menufunctionlist.getFuncurl());
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(urlSet);

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal(); //获取输入的账户
        String password = new String((char[]) authenticationToken.getCredentials()); //获取输入的密码

        ReturnMessage<Hostinfo> byLoginname = hostinfoService.findByLoginname(account);
        Hostinfo hostinfo = byLoginname.getObject();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(hostinfo, password, getName());
        return info;
    }
}
