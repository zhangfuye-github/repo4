package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 张夫业
 * @Date: 2020/9/20
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用userdao
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteById(Integer.parseInt(id));
    }

    @Override
    public User findById(String id) {
        User user=userDao.findById(Integer.parseInt(id));
        return user;
    }

    @Override
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids.length>0&&ids!=null){
            for (int i = 0; i < ids.length; i++) {
                userDao.deleteById(Integer.parseInt(ids[i]));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String rows, String currentPage, Map<String, String[]> condition) {
        //用于分页查询的实现
        //输入两个参数，返回五个参数。
        //分页查询，需要输入起始条件和每页显示的条数
        int intRows= Integer.parseInt(rows);
        int intCurPage = Integer.parseInt(currentPage);
        //调用dao层的查询方法
        int totalCount=userDao.findTotalCount(condition);//显示总记录数
        int startRow=(intCurPage-1)*intRows;
        List<User> users=userDao.findUserByPage(intRows,startRow,condition);
        int totalPage=((totalCount%intRows)==0?totalCount/intRows:totalCount/intRows+1);
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(intRows);
        pageBean.setCurrentPage(intCurPage);
        pageBean.setTotalCounts(totalCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(users);
        return pageBean;
    }
}
