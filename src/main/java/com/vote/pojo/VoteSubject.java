package com.vote.pojo;

public class VoteSubject {
    private Integer vs_id;
    private String vs_title;
    private Integer vs_type;

    public VoteSubject() {
    }

    public VoteSubject(Integer vs_id, String vs_title, Integer vs_type) {
        this.vs_id = vs_id;
        this.vs_title = vs_title;
        this.vs_type = vs_type;
    }

    @Override
    public String toString() {
        return "VoteSubject{" +
                "vs_id=" + vs_id +
                ", vs_title='" + vs_title + '\'' +
                ", vs_type=" + vs_type +
                '}';
    }

    public Integer getVs_id() {
        return vs_id;
    }

    public void setVs_id(Integer vs_id) {
        this.vs_id = vs_id;
    }

    public String getVs_title() {
        return vs_title;
    }

    public void setVs_title(String vs_title) {
        this.vs_title = vs_title;
    }

    public Integer getVs_type() {
        return vs_type;
    }

    public void setVs_type(Integer vs_type) {
        this.vs_type = vs_type;
    }
}
