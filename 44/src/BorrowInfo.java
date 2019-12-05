import javax.xml.crypto.Data;
import java.sql.Time;

public class BorrowInfo {
    private Integer studentId;
    private String studentName;
    private Integer bookId;
    private String bookName;
    private Data startTimme;
    private Data endTime;

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", startTimme=" + startTimme +
                ", endTime=" + endTime +
                '}';
    }

    public Integer getStudentId(int book_id) {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getBookId(int student_id) {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName(String student_name) {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Data getStartTimme(Time start_time) {
        return startTimme;
    }

    public void setStartTimme(Data startTimme) {
        this.startTimme = startTimme;
    }

    public Data getEndTime(Time end_time) {
        return endTime;
    }

    public void setEndTime(Data endTime) {
        this.endTime = endTime;
    }
}
