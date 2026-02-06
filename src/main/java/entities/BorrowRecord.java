package entities;

import java.util.UUID;

public class BorrowRecord {
    private String id;
    private String bookId;
    private String memberId;
    private String dueDate;

    public BorrowRecord(String bookId, String memberId, String dueDate) {
        this.id = UUID.randomUUID().toString();
        this.bookId = bookId;
        this.memberId = memberId;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
