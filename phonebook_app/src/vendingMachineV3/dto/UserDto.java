package vendingMachineV3.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDto {
    private int uId;
    private String userId;
    private String pwd;
    private String userName;
    private String telNum;
    private int userMoney;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;


    @Override
    public String toString() {
        String createDate = createdAt.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String updateDate = "";
        if(updateAt != null){
            updateDate = updateAt.format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }
        String str = String.format("%d \t %s \t %s \t %s \t %s \t %d \t \t" ,
                uId, userId, pwd, userName , telNum , userMoney,createDate, updateDate);

        return str;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }


    public UserDto() {
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }
}
