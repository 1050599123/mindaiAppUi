package org.webdriver.mindaiappui.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
public class jdbcMySql {
public static void main(String[] args) {
    Connection conn = getConnection("h3", "111111");    // 获取数据库连接
           //query(conn); //1.查询数据
           //insert(conn);//2.插入数据
           //delete(conn);//3.删除数据
           //update(conn);//4.更新数据
           //transCash(conn);//5.转账
           //execProc(conn);//6.查找存储过程无参数的
           //int cnt = getMulti(conn);//7.查找存储过程有参数的   
           //System.out.println("人员编号：" + cnt);//查找存储过程有参数的
           //planInsert(conn);//8.普通处理
           //batchInsert(conn);//9.批量处理
           // paging(conn,1,3);//10.分页显示
           //scrpllResult(conn);//11.结果集可以滚动
        releaseConnection(conn);// 释放数据库连接
     }
//1.查询数据，定义的query方法
public static void query(Connection conn){
        String Sql="select * from employees";
        try{
            Statement stmt=conn.createStatement(); //也可以使用PreparedStatement来做
          ResultSet rs=stmt.executeQuery(Sql);//执行sql语句并返还结束
                                                   
     while(rs.next()){//遍历结果集                               
            System.out.println("人员编号:"+rs.getString("employee_id")+"工资:"+rs.getString("salary"));
            }
          if(rs !=null){
            try{
                rs.close();
            } catch (SQLException e){
            e.printStackTrace();
           }
        }
        if(stmt !=null){
            try{
               stmt.close();
            }catch(SQLException e){
             e.printStackTrace();
          }
        }
        if(conn !=null){
            try{
                conn.close();
               }catch(SQLException e){
                e.printStackTrace();
            }
        }
     }catch(Exception e){
       e.printStackTrace();
     }
}
//2.插入数据    
     public static void insert(Connection conn) {  
            try {  
                  String sql = "insert into employees(employee_id,last_name,salary,department_id,userid)"  
                        + " values ('100010', 'xiaogou', '7000','004','9')"; // 插入数据的sql语句  
                  Statement stmt1 =conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
                  int count = stmt1.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数       
               System.out.println("向biao中插入了 " + count + " 条数据"); //输出插入操作的处理结果  
               conn.close();   //关闭数据库连接  
                } catch (SQLException e) {  
                  e.printStackTrace(); 
             }  
        }
//3.删除数据
    public static void delete(Connection conn){
            String Sql = "delete  from employees  where employee_id=100009";
        try {
             Statement stmt = conn.createStatement();// 或者用PreparedStatement方法
             stmt.executeUpdate(Sql);//执行sql语句
        if (stmt != null) {
        try {
             stmt.close();
             } catch (SQLException e) {
             e.printStackTrace();
             }
           }
        } catch (SQLException e) {
             e.printStackTrace();
           }
            
        }
//4.更新数据  
    public static void update(Connection conn){
              String Sql = "update  employees set salary=8000 where employee_id=100005";
        try {
             Statement stmt1 = conn.createStatement();//或者用PreparedStatement方法
             stmt1.executeUpdate(Sql);//执行sql语句
        if (stmt1 != null) {
             try {
                stmt1.close();
             } catch (SQLException e) {
                e.printStackTrace();
             }
         }
            } catch (SQLException e) {
               e.printStackTrace();
             }
          }    
//5.转账(数据调换)(原来数据为100和500，实现这个功能后变成500和100，其实说白了就是更新数据，改数据)
  public static void transCash(Connection conn){
            Statement stmt = null;
        try{
              conn.setAutoCommit(false);//关闭自动提交
                String sql = "update employees set salary=500 where employee_id=100001";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);            
                      sql = "update employees set salary=100 where employee_id=100002";
                stmt.executeUpdate(sql);//执行sql语句，上面的两个工资将会调换
              conn.commit();//提交事务
           }catch(Exception e){
             e.printStackTrace();
           }finally{
        try{
             if(stmt != null)stmt.close();
                }catch(Exception e){
                  e.printStackTrace();
                }
              }
            }
//6.调用无参存储过程；
  public static void execProc(Connection conn){
           String sql = "{call raisesalary}";
      try {
          CallableStatement cstmt = conn.prepareCall(sql);
          cstmt.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
   } 
//7.查找存储过程有参
  public static int getMulti(Connection conn) {
           int dept_id = 100001;
           int cnt = 0;
           String sql = "{call calc_emp_count(?,?)}";
        try {
              CallableStatement cstmt = conn.prepareCall(sql);//初始化Statement对象
              cstmt.setInt(1, dept_id);//CallableStatement.setxxx(参数，值)或者(数字,值),而PreparedStatement.setxxx(数字,值)只能这样
              cstmt.setInt(2, cnt);    //
              cstmt.registerOutParameter(2, Types.INTEGER);//声明输出参数
              cstmt.executeUpdate();//执行sql语句
              cnt = cstmt.getInt(2);//获取结果
          if (cstmt != null) {
                cstmt.close();// 释放Statement对象
              }
            } catch (Exception e) {
              e.printStackTrace();
          }
           return cnt;
      }
//8.普通处理
     public static void planInsert(Connection conn) {  
         try {  
               String sql = "insert into test_user1(userid,username,loadingtime)"  
                     + " values (?,?,?)"; // 插入数据的sql语句  
               PreparedStatement pstmt=conn.prepareStatement(sql);
               long startTime=System.currentTimeMillis();
             for(int i=0;i<1000;i++){
                 pstmt.setLong(1, i);
                 pstmt.setString(2, "user"+i);
                 pstmt.setDate(3, new Date(System.currentTimeMillis()));
                 pstmt.executeUpdate();
             }
         System.out.println("总共耗时："+(System.currentTimeMillis() - startTime));
               pstmt.close();   //关闭数据库连接  
           } catch (SQLException e) {  
             e.printStackTrace(); 
         } 
     } 
//9.批量插入的速度要比普通处理的速度快
    public static void batchInsert(Connection conn) {  
             try {  
                   String sql = "insert into test_user1(userid,username,loadingtime)"  
                         + " values (?,?,?)"; // 插入数据的sql语句  
                   PreparedStatement pstmt=conn.prepareStatement(sql);
                   long startTime=System.currentTimeMillis();
                 for(int i=0;i<1000;i++){
                     pstmt.setLong(1, i);
                     pstmt.setString(2, "user"+i);
                     pstmt.setDate(3, new Date(System.currentTimeMillis()));
                     pstmt.addBatch();//添加到批量处理
                 }
                 int[] result=pstmt.executeBatch();
              System.out.println("总共耗时："+(System.currentTimeMillis() - startTime));
                 pstmt.close();   //关闭数据库连接  
              } catch (SQLException e) {  
                 e.printStackTrace(); 
             } 
         }
//10.分页查询
   public static void paging(Connection conn,int startIndex,int total){
            try{
                String sql="select * from employees limit ?,?";
                PreparedStatement pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1, startIndex);
                pstmt.setInt(2, total);
                ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                    System.out.print("工号："+rs.getInt(1));
                   System.out.println("部门编号："+rs.getInt("department_id"));
                }rs.close();
                pstmt.close();
              }catch(SQLException e){
                e.printStackTrace();
            }
        }
//11.结果集滚动显示
     public static void scrpllResult(Connection conn){
         try{
             String sql="select * from employees";                         //结果集可以滚动                                               //并发性,结果集只读，不可以修改
             PreparedStatement pstmt=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs=pstmt.executeQuery();
         while(rs.next()){  //向下一行遍历
                 System.out.print("工号："+rs.getLong(1));
                 System.out.println("名字"+rs.getString("last_name"));
            }while(rs.previous()){//向上一行遍历
                 System.out.print("工号："+rs.getLong(1));
                 System.out.println("工资"+rs.getInt("salary"));
              }
                rs.absolute(6);//表示直接跳到第几行
             if(rs.next()){
                 System.out.print("工号："+rs.getLong(1));
                 System.out.println("..........部门编号："+rs.getString("department_id"));
               }
                 rs.close();
                 pstmt.close();
             }catch(SQLException e){
                 e.printStackTrace();
             }
         } 
//数据库连接
public static Connection getConnection(String user, String pass) {
          Connection conn = null;//声明连接对象
          String driver = "com.mysql.jdbc.Driver";// 驱动程序类名
          String url = "jdbc:mysql://localhost:3306/test?" // 数据库URL
                     + "useUnicode=true&characterEncoding=UTF8";// 防止乱码
   try {
        Class.forName(driver);// 注册(加载)驱动程序
        conn = DriverManager.getConnection(url, user, pass);// 获取数据库连接
       } catch (Exception e) {
         e.printStackTrace();
      }
        return conn;
     }
//释放数据库连接
public static void releaseConnection(Connection conn) {
     try {
          if (conn != null)
               conn.close();
         } catch (Exception e) {
           e.printStackTrace();
         }
     }
 }
