<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.itheima.dao.UserDao" %>
<%@ page import="com.itheima.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1.加载配置文件
    InputStream resource = Resources.getResourceAsStream("SqlMapConfing.xml");
    //2.创建 SqlSessionFactory 的构建者对象
    SqlSessionFactoryBuilder sqlSessionBuilder=new SqlSessionFactoryBuilder();
    //3.使用构建者创建工厂对象 SqlSessionFactory
    SqlSessionFactory factory = sqlSessionBuilder.build(resource);
    //4.使用 SqlSessionFactory 生产 SqlSession 对象
    SqlSession sqlSession = factory.openSession();
    //5.使用 SqlSession 创建 dao 接口的代理对象
    UserDao mapper = sqlSession.getMapper(UserDao.class);
    //6.使用代理对象执行查询所有方法
    List<User> all = mapper.findAll();
    for (User user : all) {
        System.out.println(user);
    }
    //7.释放资源
    sqlSession.close();
    resource.close();
%>
</body>
</html>
