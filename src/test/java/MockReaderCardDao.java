import com.book.dao.ReaderCardDao;
import com.book.domain.ReaderCard;

public class MockReaderCardDao extends ReaderCardDao {
    //定义了 expectedReaderCard 和 expectedMatchCount 变量：这些变量用于存储预期的返回值和匹配计数。
    private ReaderCard expectedReaderCard;

    private int expectedMatchCount;
    //提供了 setExpectedMatchCount() 和 setExpectedReaderCard() 方法：
    //这些方法用于设置预期的返回值和匹配计数。在测试中，你可以使用这些方法设置预期的值，以便验证被测试方法的行为和结果。
    public void setExpectedMatchCount(int matchCount) {
        this.expectedMatchCount = matchCount;
    }

    @Override
    public int getMatchCount(int readerId, String password) {
        return expectedMatchCount;
    }

    public void setExpectedReaderCard(ReaderCard readerCard) {
        this.expectedReaderCard = readerCard;
    }
    //重写了 getMatchCount() 和 findReaderByReaderId() 方法：
    //这些方法是 ReaderCardDao 中的方法，通过重写它们来实现模拟。在重写的方法中，直接返回预期的返回值和对象，而不执行实际的数据库操作。
    @Override
    public ReaderCard findReaderByReaderId(int readerId) {
        return expectedReaderCard;
    }

}



