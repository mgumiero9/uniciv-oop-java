package model;

public class UserTelephone {
    private Long id;
    private String number;
    private String type;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserTelephone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", userId=" + userId +
                '}';
    }
}
