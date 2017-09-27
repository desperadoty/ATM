package dao;

import com.po.Account;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/2.
 * 业务逻辑类
 * 与accounts表相关的操作
 * 功能：
 * 1.验证银行卡号
 * 2.验证密码
 * 3.查询余额
 * 4.用户取款
 * 5.用户存款
 * 6.用户转账
 * 7.判断余额是否不足
 * 8.修改密码
 */
public class AccountDAO {

    //验证银行卡号
    public boolean checkAccount(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean flag = false;

        try {
            conn = DBHelper.getConn(); //获取数据库连接
            String sql = "SELECT * FROM accounts WHERE id = ?;";// SQL语句
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,account.getId());
            rs = stmt.executeQuery();

            if(rs.next()) {
                account.setId(rs.getString("id"));
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //释放资源
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }


    //验证密码
    public boolean CheckLogin(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean flag = false;

        try {
            conn = DBHelper.getConn();
            String sql = "SELECT id FROM accounts WHERE id = ? AND password = ?;";//SQL语句
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,account.getId());
            stmt.setString(2,account.getPassword());
            rs = stmt.executeQuery();

            if(rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }


    //查询余额
    public int Inquire(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int balance = 0;

        try {
            conn = DBHelper.getConn();
            String sql = "SELECT balance FROM accounts WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,account.getId());
            rs = stmt.executeQuery();

            if(rs.next()) {
                balance = rs.getInt("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return balance;
    }

    //判断余额是否不足
    public boolean isSufficient(Account account,String money) {

        Double mon = Double.parseDouble(money);
        System.out.println(account.getBalance());
        System.out.println(mon);
        if(account.getBalance() - mon < 0) {
            return false;
        }
        return true;
    }


    //取款
    public boolean drawMoney(Account account,String draw) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int a = 0;

        boolean flag = false;

       if(!isSufficient(account, draw)) {
           return false;
       }

        try {
            conn = DBHelper.getConn();
            String sql = "UPDATE accounts SET balance = balance - ? WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1,Double.parseDouble(draw));
            stmt.setString(2,account.getId());
            a = stmt.executeUpdate();

            if(a == 1) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    //存款
    public boolean depositMoney(Account account,String deposit) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int a = 0;
        boolean flag = false;

        try {
            conn = DBHelper.getConn();
            String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1,Double.parseDouble(deposit));
            stmt.setString(2,account.getId());
            a = stmt.executeUpdate();

            if(a == 1) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    //转账
    public boolean transferMoney(Account account1,Account account2,double money) {
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        int a1 = 0, a2 = 0;
        boolean flag = false;

        if(!isSufficient(account1,String.valueOf(money))) {
            return false;
        }

        try {
            conn = DBHelper.getConn();
            conn.setAutoCommit(false);
            String sql1 = "UPDATE accounts SET balance = balance - ? WHERE id = ?;";
            String sql2 = "UPDATE accounts SET balance = balance + ? WHERE id = ?;";

            stmt1 = conn.prepareStatement(sql1);
            stmt1.setDouble(1,money);
            stmt1.setString(2,account1.getId());
            a1 = stmt1.executeUpdate();
//            int a = 1/0; //测试事务管理成功与否
            stmt2 = conn.prepareStatement(sql2);
            stmt2.setDouble(1,money);
            stmt2.setString(2,account2.getId());
            a2 = stmt2.executeUpdate();
            if(a1 == 1 && a2 == 1) {
                flag = true;
            } else {
                flag = false;
            }
            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if(stmt1 != null) {
                try {
                    stmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt2 != null) {
                try {
                    stmt2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    //按卡号查询账号
    public Account inquireById(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Account account = new Account();

        String sql = "SELECT * FROM accounts WHERE id = ?;";
        try {
            conn = DBHelper.getConn();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,id);
            rs = stmt.executeQuery();

            if(rs.next()) {
                account.setId(id);
                account.setUsername(rs.getString("username"));
                account.setGender(rs.getString("gender"));
                account.setPassword(rs.getString("password"));
                account.setBalance(rs.getInt("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return account;
    }

    //修改密码
    public boolean changePassword(Account account,String password) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int a = 0;
        boolean flag = false;

        try {
            conn = DBHelper.getConn();
            String sql = "UPDATE accounts SET password = ? WHERE id = ?";
            stmt =conn.prepareStatement(sql);
            stmt.setString(1,password);
            stmt.setString(2,account.getId());

            a = stmt.executeUpdate();

            if(a == 1) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
