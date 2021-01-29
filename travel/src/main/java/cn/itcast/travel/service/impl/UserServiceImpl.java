package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @Auther: 张夫业
 * @Date: 2020/10/15
 * @Description:
 */
public class UserServiceImpl implements UserService {
    /**
     * 用来注册用户,在该层进行简单逻辑处理
     * @param user
     * @return
     */
    private UserDao dao=new UserDaoImpl();
    @Override
    public boolean registUser(User user) {
        //1.首先判断用户名是否存在
        User user1 = dao.findByUser(user.getUsername());
        //2.如果用户存在
        if(user1==null){
            user.setStatus("N");
            user.setCode(UuidUtil.getUuid());
            System.out.println(user.getCode());
            try {
                String content="<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>点击进行激活</a>";
                MailUtils.sendMail(user.getEmail(),content,"旅游网账号激活");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dao.saveUser(user);
        }else {
            return false;
        }

    }

    @Override
    public boolean activeUser(String code) {
        //1.首先根据激活码，查询用户是否存在
        User user=dao.findUserByCode(code);
        if(user!=null){
            //如果用户不为空，则进行用户的激活
//            String status = user.getStatus();
//            if("N".equals(status)){
                user.setStatus("Y");
                dao.updateUser(user.getUsername(),user.getStatus());
                return true;
//            }
        }
        //激活码无效
        return false;
    }

    /***
     * 用户的登录方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public User loginUser(String username, String password) {
//        String sql="select * from tab_user where username=? and password=?";
        User user = dao.loginUser(username,password);
        return user;
    }

    @Override
    public User findByName(String user) {
        User user1=dao.findByName(user);
        return user1;
    }
}
