import com.book.dao.ReaderInfoDao;
import com.book.domain.ReaderInfo;

public class MockReaderInfoDao extends ReaderInfoDao {
    private ReaderInfo expectedReaderInfo;

    public void setExpectedReaderInfo(ReaderInfo readerInfo) {
        this.expectedReaderInfo = readerInfo;
    }

    @Override
    public ReaderInfo findReaderInfoByReaderId(int readerId) {
        return expectedReaderInfo;
    }

    // 其他方法的模拟实现...
}


