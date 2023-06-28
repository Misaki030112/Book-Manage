import com.book.dao.AdminDao;

public class MockAdminDao extends AdminDao {
    @Override
    public int getMatchCount(int adminId, String password) {
        // 返回预先定义的匹配数，用于模拟数据库操作
        return 1;
    }

    @Override
    public int rePassword(int adminId, String newPasswd) {
        // 返回预先定义的更新密码操作结果，用于模拟数据库操作
        return 1;
    }

    @Override
    public String getPasswd(int id) {
        // 返回预先定义的管理员密码，用于模拟数据库操作
        return "adminpassword";
    }
}

