package com.data;

/**
 * @PACKAGE_NAME: com.data
 * @NAME: Users
 * @USER: "guzhenhua"
 * @DATE: 2020/7/7
 * @TIME: 16:26
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 07
 * @DAY_NAME_SHORT: 周二
 * @DAY_NAME_FULL: 星期二
 * @HOUR: 16
 * @MINUTE: 26
 * @PROJECT_NAME: CSDN
 */
public class Users {
    String teamName;
    int gameId;
    String teamUrl;

    public Users() {
    }

    public Users(String teamName, int gameId, String teamUrl) {
        this.teamName = teamName;
        this.gameId = gameId;
        this.teamUrl = teamUrl;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTeamUrl() {
        return teamUrl;
    }

    public void setTeamUrl(String teamUrl) {
        this.teamUrl = teamUrl;
    }

    @Override
    public String toString() {
        return "Users{" +
                "teamName='" + teamName + '\'' +
                ", gameId='" + gameId + '\'' +
                ", teamUrl='" + teamUrl + '\'' +
                '}';
    }
}
