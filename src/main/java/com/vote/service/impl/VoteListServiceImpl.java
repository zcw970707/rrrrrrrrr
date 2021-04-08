package com.vote.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vote.mapper.VoteListMapper;
import com.vote.pojo.VoteItem;
import com.vote.pojo.VoteOption;
import com.vote.pojo.VoteSubject;
import com.vote.service.VoteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VoteListServiceImpl implements VoteListService {
    @Autowired
    private VoteListMapper vm;
    @Override
    public Page<Map<String, Object>> findAll(int pageIndex,int pageSize,String vs_title) {
        Page<Map<String, Object>> objects = PageHelper.startPage(pageIndex, pageSize);
        vm.findAll(vs_title);
        return objects;
    }


    @Override
    public List<Map<String,Object>> findById(Integer id) {
        return vm.findById(id);
    }

    @Override
    public List<VoteOption> joinVote(int id) {
        return vm.joinVote(id);
    }

    @Override
    public List<Map<String,Object>>  usersVote(int vu_user_id,int vs_id) {
        return vm.usersVote(vu_user_id,vs_id);
    }

    @Override
    public VoteSubject titleVote(String title) {
        return vm.titleVote(title);
    }


    @Override
    public int addVoteMsg(VoteSubject voteSubject) {
        return vm.addVoteMsg(voteSubject);
    }

    @Override
    public int addVoteMsg1(List<VoteOption> list) {
        return vm.addVoteMsg1(list);
    }

    @Override
    public int updateVote(VoteSubject voteSubject) {
        return vm.updateVote(voteSubject);
    }

    @Override
    public int addVoteCount(VoteItem voteItem) {
        return vm.addVoteCount(voteItem);
    }

    @Override
    public VoteSubject typeVote(VoteSubject voteSubject) {
        return vm.typeVote(voteSubject);
    }

    @Override
    public Map<String, Object> optionVote(VoteOption voteItem) {
        return vm.optionVote(voteItem);
    }

    @Override
    public List<VoteOption> allVoteOption(VoteOption voteOption) {
        return vm.allVoteOption(voteOption);
    }

    @Override
    public int delVi(VoteItem voteItem) {
        return vm.delVi(voteItem);
    }

    @Override
    public int modifyVo(VoteOption voteOption) {

        return vm.modifyVo(voteOption);
    }

    @Override
    public int delVo(VoteOption voteOption) {
        return vm.delVo(voteOption);
    }

    @Override
    public int addVo(VoteOption voteOption) {
        return vm.addVo(voteOption);
    }

    @Override
    public VoteOption selectId(VoteOption voteOption) {
        return vm.selectId(voteOption);
    }

    @Override
    public VoteOption selectTitle(VoteOption voteOption) {
        return vm.selectTitle(voteOption);
    }

    @Override
    public int selectOptionNums(int id) {
        return vm.selectOptionNums(id);
    }

    @Override
    public int delVoteSubject(int id) {
        return vm.delVoteSubject(id);
    }

    @Override
    public int delVoteOption(int id) {
        return vm.delVoteOption(id);
    }

    @Override
    public int delVoteItem(int id) {
        return vm.delVoteItem(id);
    }

}
