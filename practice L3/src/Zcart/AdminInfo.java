package Zcart;

import java.util.List;

public class AdminInfo {
    private String userName;
    private String password;
    private List<String> passwordList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPasswordList() {
        return passwordList;
    }

    public void setPasswordList(List<String> passwordList) {
        this.passwordList = passwordList;
    }
}
