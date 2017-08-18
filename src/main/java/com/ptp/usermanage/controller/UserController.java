package com.ptp.usermanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ptp.usermanage.bean.ResponseResult;
import com.ptp.usermanage.bean.ResultCount;
import com.ptp.usermanage.pojo.User;
import com.ptp.usermanage.service.UserService;


@RequestMapping("user")
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public ResultCount queryUserList(@RequestParam(value = "page",defaultValue= "1")Integer page,
            @RequestParam(value = "rows",defaultValue= "5")Integer rows){
        
        return this.userService.queryUserList(page, rows);
    }
    
    /**
     * 根据用户id查询用户数据
     * @param id
     * @return
     */
    @RequestMapping(value ="{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> queryUserById(@PathVariable("id") String id){
        try{
            User user = this.userService.queryUserById(id);
            if(null == user){
                //资源不存在，响应404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //200
            //return ResponseEntity.status(HttpStatus.OK).body(user);
            return ResponseEntity.ok(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value ="create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult saveUser(User user){
        try{
            ResponseResult result=this.userService.saveUser(user);
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseResult.build(500, "Internal Server Error");
    }
    
    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(User user){
        try{
            this.userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "uuid",defaultValue="0") String id){
        try{
            if(id.toString().equals("0")){
                //请求参数有误
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            this.userService.deleteUserById(id);
            //204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
