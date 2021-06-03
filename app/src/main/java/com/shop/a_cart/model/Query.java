package com.shop.a_cart.model;

public class Query {
    String ques;
    String ans;
    boolean isExpandable;

    public Query(String ques, String ans) {
        this.ques = ques;
        this.ans = ans;
        this.isExpandable = false;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
