package com.vote.pojo;

public class VoteItem {
    private Integer vi_id;
    private Integer vu_user_id;
    private Integer vs_id;
    private Integer vo_id;

    public VoteItem() {
    }

    public VoteItem(Integer vi_id, Integer vu_user_id, Integer vs_id, Integer vo_id) {
        this.vi_id = vi_id;
        this.vu_user_id = vu_user_id;
        this.vs_id = vs_id;
        this.vo_id = vo_id;
    }

    public Integer getVi_id() {
        return vi_id;
    }

    public void setVi_id(Integer vi_id) {
        this.vi_id = vi_id;
    }

    public Integer getVu_user_id() {
        return vu_user_id;
    }

    public void setVu_user_id(Integer vu_user_id) {
        this.vu_user_id = vu_user_id;
    }

    public Integer getVs_id() {
        return vs_id;
    }

    public void setVs_id(Integer vs_id) {
        this.vs_id = vs_id;
    }

    public Integer getVo_id() {
        return vo_id;
    }

    public void setVo_id(Integer vo_id) {
        this.vo_id = vo_id;
    }

    @Override
    public String toString() {
        return "VoteItem{" +
                "vi_id=" + vi_id +
                ", vu_user_id=" + vu_user_id +
                ", vs_id=" + vs_id +
                ", vo_id=" + vo_id +
                '}';
    }
}
