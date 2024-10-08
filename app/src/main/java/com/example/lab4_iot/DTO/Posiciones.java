package com.example.lab4_iot.DTO;

public class Posiciones {
    private String intRank;
    private String strTeam;
    private String strBadge;
    private int intWin;
    private int intDraw;
    private int intLoss;
    private int intGoalsFor;
    private int intGoalsAgainst;
    private int intGoalDifference;
    private int intPoints;

    public String getIntRank() {
        return intRank;
    }

    public void setIntRank(String intRank) {
        this.intRank = intRank;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public int getIntDraw() {
        return intDraw;
    }

    public void setIntDraw(int intDraw) {
        this.intDraw = intDraw;
    }

    public int getIntWin() {
        return intWin;
    }

    public void setIntWin(int intWin) {
        this.intWin = intWin;
    }

    public int getIntLoss() {
        return intLoss;
    }

    public void setIntLoss(int intLoss) {
        this.intLoss = intLoss;
    }

    public int getIntGoalsAgainst() {
        return intGoalsAgainst;
    }

    public void setIntGoalsAgainst(int intGoalsAgainst) {
        this.intGoalsAgainst = intGoalsAgainst;
    }

    public int getIntGoalsFor() {
        return intGoalsFor;
    }

    public void setIntGoalsFor(int intGoalsFor) {
        this.intGoalsFor = intGoalsFor;
    }

    public int getIntGoalDifference() {
        return intGoalDifference;
    }

    public void setIntGoalDifference(int intGoalDifference) {
        this.intGoalDifference = intGoalDifference;
    }

    public int getIntPoints() {
        return intPoints;
    }

    public void setIntPoints(int intPoints) {
        this.intPoints = intPoints;
    }
}
