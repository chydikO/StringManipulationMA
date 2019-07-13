package com.company.model;

public class ConnectionInfo implements Comparable<ConnectionInfo> {
    private User user;
    private Integer sessionID;
    private String userIP;
    private Long time;

    public ConnectionInfo() {
    }

    public ConnectionInfo(Integer sessionID, String userIP, Long time, User user) {
        this.user = user;
        this.sessionID = sessionID;
        this.userIP = userIP;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

        @Override
        public int compareTo(ConnectionInfo connectionInfo) {
            if (this.time > connectionInfo.time) {
                return 1;
            } else if (this.time < connectionInfo.time) {
                return -1;
            }
            return 0;
        }

    @Override
    public String toString() {
        return time + " " + sessionID + " " + userIP + " " + user.getLogin() +
                " " + user.getPassword() + " " + user.getId();
    }


}