package com.mengfei.security.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Menulist;
import com.mengfei.security.pojo.Rolepriinfo;
import com.mengfei.security.pojo.Rolestore;
import com.mengfei.security.service.MenulistService;
import com.mengfei.security.service.RolepriinfoService;
import com.mengfei.security.service.RolestoreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    private RolestoreService rolestoreService;

    @Autowired
    private RolepriinfoService rolepriinfoService;

    @Autowired
    private MenulistService menulistService;

    /**
     * 将发布方的角色信息放入缓存
     */

    /**
     * 获取发布方的角色ID集合
     */
    @RequestMapping("/getRolesByStoreId")
    public Set<Long> getRolesByStoreId(){
        ReturnMessage<Rolestore> dbReturnMessage = rolestoreService.findByHostshopid(92);
        List<Rolestore> rolestoreList = dbReturnMessage.getList();
        Set<Long> roleIdSet = new HashSet<>();
        for(Rolestore rolestore : rolestoreList){
            roleIdSet.add(rolestore.getRoleid());
        }
        return roleIdSet;
    }

    /**
     * 通过发布方角色来加载首页一级菜单
     */
    @RequestMapping("/getFirstMenuByRoles")
    public Object getFirstMenuByRoles(){
        Set<Long> roleIdSet = this.getRolesByStoreId();
        ReturnMessage<Rolepriinfo> firstMenuList = rolepriinfoService.findByRoleIdSet(roleIdSet, 0);
        List<Rolepriinfo> list = firstMenuList.getList();
        JsonArray array = new JsonArray();
        for(Rolepriinfo rolepriinfo : list){
            //通过menuid获取menu信息
            ReturnMessage<Menulist> byId = menulistService.findById(rolepriinfo.getMenuid());
            Menulist menu = byId.getObject();

            JsonObject object = new JsonObject();
            object.addProperty("path",menu.getMenuurl());
            object.addProperty("name",menu.getMenutext());
            object.addProperty("root",true);

            array.add(object);
        }

        JsonObject object = new JsonObject();
        object.add("menus",array);

        return object;
    }

    /**
     * 通过发布方角色和一级菜单ID来加载二级菜单
     */
    @RequestMapping("/getSecondMenuByFirstMenuAndRoles")
    public Object getSecondMenuByFirstMenuAndRoles(){
        return null;
    }

    /**
     * 通过发布方角色和二级菜单ID来加载按钮
     */

    @RequestMapping("/account/update")
    @RequiresPermissions("/api/account/update")
    public String update(){
        return "update sucess";
    }

    @RequestMapping("/account/delete")
    @RequiresPermissions("/api/account/delete")
    public String delete(){
        return "delete sucess";
    }
}
