import com.book.dao.AdminDao;
import com.book.dao.ReaderCardDao;
import com.book.dao.ReaderInfoDao;
import com.book.domain.ReaderCard;
import com.book.domain.ReaderInfo;
import com.book.service.LoginService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginServiceTest {
    private LoginService loginService;

    @Before
    public void setUp() {
        // 创建LoginService对象
        loginService = new LoginService();

        // 创建模拟的DAO对象并设置到LoginService中
        ReaderCardDao mockReaderCardDao = new MockReaderCardDao();
        ReaderInfoDao mockReaderInfoDao = new MockReaderInfoDao();
        //模拟的 DAO 类，实现了相应的接口
        AdminDao mockAdminDao = new MockAdminDao();
        loginService.setReaderCardDao(mockReaderCardDao);
        loginService.setReaderInfoDao(mockReaderInfoDao);
        loginService.setAdminDao(mockAdminDao);
    }

    @Test
    public void testHasMatchReader() {
        // 测试hasMatchReader方法
        int readerId = 123;
        String password = "password";

        // 创建LoginService对象
        LoginService loginService = new LoginService();

        // 使用模拟的ReaderCardDao对象
        MockReaderCardDao mockReaderCardDao = new MockReaderCardDao();
        loginService.setReaderCardDao(mockReaderCardDao);

        // 模拟ReaderCardDao返回匹配的结果
        mockReaderCardDao.setExpectedMatchCount(1);

        boolean hasMatch = loginService.hasMatchReader(readerId, password);

        Assert.assertTrue(hasMatch);
    }



    @Test
    public void testFindReaderCardByUserId() {
        // 测试findReaderCardByUserId方法
        int readerId = 123;

        // 使用模拟的ReaderCardDao对象
        MockReaderCardDao mockReaderCardDao = new MockReaderCardDao();
        loginService.setReaderCardDao(mockReaderCardDao);

        // 模拟ReaderCardDao返回预期的ReaderCard对象
        ReaderCard expectedReaderCard = new ReaderCard();
        expectedReaderCard.setReaderId(readerId);
        mockReaderCardDao.setExpectedReaderCard(expectedReaderCard);

        ReaderCard readerCard = loginService.findReaderCardByUserId(readerId);

        Assert.assertNotNull(readerCard);
        Assert.assertEquals(readerId, readerCard.getReaderId());
    }

    @Test
    public void testFindReaderInfoByReaderId() {
        // 测试findReaderInfoByReaderId方法
        int readerId = 123;

        // 使用模拟的ReaderInfoDao对象
        MockReaderInfoDao mockReaderInfoDao = new MockReaderInfoDao();
        loginService.setReaderInfoDao(mockReaderInfoDao);

        // 模拟ReaderInfoDao返回预期的ReaderInfo对象
        ReaderInfo expectedReaderInfo = new ReaderInfo();
        expectedReaderInfo.setReaderId(readerId);
        mockReaderInfoDao.setExpectedReaderInfo(expectedReaderInfo);

        ReaderInfo readerInfo = loginService.findReaderInfoByReaderId(readerId);

        Assert.assertNotNull(readerInfo);
        Assert.assertEquals(readerId, readerInfo.getReaderId());
    }


    @Test
    public void testHasMatchAdmin() {
        // 测试hasMatchAdmin方法
        int adminId = 456;
        String password = "adminpass";
        boolean result = loginService.hasMatchAdmin(adminId, password);
        Assert.assertTrue(result);
    }

    @Test
    public void testAdminRePasswd() {
        // 测试adminRePasswd方法
        int adminId = 456;
        String newPasswd = "newpass123";
        boolean result = loginService.adminRePasswd(adminId, newPasswd);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetAdminPasswd() {
        // 测试getAdminPasswd方法
        int adminId = 456;
        String passwd = loginService.getAdminPasswd(adminId);
        Assert.assertNotNull(passwd);
    }
}
