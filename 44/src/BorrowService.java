import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowService {



    public static List<BorrowInfo> queryBOOKName(String name) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BorrowInfo> infos = new ArrayList<>();
        try {
            connection = DButil.getConnection();
            String sql = "select s.id student_id,s.name student_name,b.id book_id," +
                    "  b.name book_name,borrow_info.start_time,borrow_info.end_time" +
                    "  from borrow_info" +
                    "  join student s ON borrow_info.student_id = s.id" +
                    "  JOIN book b ON borrow_info.book_id = b.id where b.name = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                BorrowInfo info = new BorrowInfo();
                info.getStudentId(rs.getInt("student_id"));
                info.getBookName(rs.getNString("student_name"));
                info.getBookId(rs.getInt("book_id"));
                info.getBookName(rs.getString("book_name"));
                info.getStartTimme(rs.getTime("start_time"));
                info.getEndTime(rs.getTime("end_time"));
                infos.add(info);
            }
        } catch (Exception e) {

        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return infos;
    }

    public static void main(String[] args) {
        System.out.println(queryBOOKName("史记"));
    }
}
