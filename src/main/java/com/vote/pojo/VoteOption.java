package com.vote.pojo;

public class VoteOption {
    private Integer vo_id;
    private Integer vs_id;
    private String vo_option;
    private Integer vo_order;

    public VoteOption() {
    }

    public VoteOption(Integer vo_id, Integer vs_id, String vo_option, Integer vo_order) {
        this.vo_id = vo_id;
        this.vs_id = vs_id;
        this.vo_option = vo_option;
        this.vo_order = vo_order;
    }

    public Integer getVo_id() {
        return vo_id;
    }

    public void setVo_id(Integer vo_id) {
        this.vo_id = vo_id;
    }

    public Integer getVs_id() {
        return vs_id;
    }

    public void setVs_id(Integer vs_id) {
        this.vs_id = vs_id;
    }

    public String getVo_option() {
        return vo_option;
    }

    public void setVo_option(String vo_option) {
        this.vo_option = vo_option;
    }

    public Integer getVo_order() {
        return vo_order;
    }

    public void setVo_order(Integer vo_order) {
        this.vo_order = vo_order;
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "vo_id=" + vo_id +
                ", vs_id=" + vs_id +
                ", vo_option='" + vo_option + '\'' +
                ", vo_order=" + vo_order +
                '}';
    }
}
