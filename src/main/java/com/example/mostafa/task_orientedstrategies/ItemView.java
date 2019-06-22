package com.example.mostafa.task_orientedstrategies;

public class ItemView {

    private String head;
    private String score;

ItemView(String content){
    setHead(head);
    score = "Score: 0/5";
}

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
