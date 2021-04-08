package com.vote.service;

import com.github.pagehelper.Page;
import com.vote.pojo.VoteItem;
import com.vote.pojo.VoteOption;
import com.vote.pojo.VoteSubject;

import java.util.List;
import java.util.Map;

public interface VoteListService {
    Page<Map<String,Object>> findAll(int pageIndex,int pageSize,String vs_title);//展示页方法，标题，投票数，选项数
    List<Map<String,Object>> findById(Integer id);//投票详情
    List<VoteOption> joinVote(int id);//参与投票
    List<Map<String,Object>> usersVote(int vu_user_id,int vs_id);//一个用户一个主题只能投一次票
    VoteSubject titleVote(String title);//投票主题不能相同
    int addVoteMsg(VoteSubject voteSubject);//添加投票信息
    int addVoteMsg1(List<VoteOption> list);//添加投票信息
    int updateVote(VoteSubject voteSubject);//修改投票信息
    int addVoteCount(VoteItem voteItem);//我要参与的方法，向投票表添加数据

    VoteSubject typeVote(VoteSubject voteSubject);
    Map<String,Object> optionVote(VoteOption voteOption);

    List<VoteOption> allVoteOption(VoteOption voteOption);


    int delVi(VoteItem voteItem);//删除以前存在的选项投票

    int modifyVo(VoteOption voteOption);//修改选项名
    int delVo(VoteOption voteOption);//删除选项名
    int addVo(VoteOption voteOption);//添加选项名


    VoteOption selectId(VoteOption voteOption);
    VoteOption selectTitle(VoteOption voteOption);


    int selectOptionNums(int id);

    int delVoteSubject(int id);
    int delVoteOption(int id);
    int delVoteItem(int id);
}
