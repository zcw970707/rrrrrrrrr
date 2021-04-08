package com.vote.controller;

import com.github.pagehelper.Page;
import com.vote.pojo.Users;
import com.vote.pojo.VoteItem;
import com.vote.pojo.VoteOption;
import com.vote.pojo.VoteSubject;
import com.vote.service.VoteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class VoteItemController {
    @Autowired
    private VoteListService vs;

    @RequestMapping("/findAll")
    public String findAllVote(String pageIndex, Model mm, String flag, String vs_title) {
        int pageSize = 1;
        if (pageIndex == null || pageIndex == "") {
            pageIndex = "1";
        }
        if (flag == null || flag == "") {
            flag = "1";
        }
        Page<Map<String, Object>> pp = vs.findAll(Integer.valueOf(pageIndex), pageSize, vs_title);
        List<Map<String, Object>> ppList = pp.getResult();
        mm.addAttribute("flag", flag);
        mm.addAttribute("page", pp);
        mm.addAttribute("pageResult", ppList);
        return "votelist";
    }

    @RequestMapping("/addVote")
    public String addVote(VoteSubject vsbu, String[] vo_option) {
        int num = vs.addVoteMsg(vsbu);
        int order = 1;
        VoteSubject vsbu1 = vs.titleVote(vsbu.getVs_title());
        if (num > 0) {
            List<VoteOption> voList = new ArrayList<VoteOption>();
            for (int i = 0; i < vo_option.length; i++) {
                VoteOption vo = new VoteOption();
                vo.setVs_id(vsbu1.getVs_id());
                vo.setVo_option(vo_option[i]);
                vo.setVo_order(order++);
                voList.add(vo);
            }
            int num1 = vs.addVoteMsg1(voList);
            if (num1 > 0) {
                return "forward:/findAll";
            } else {
                return "add";
            }
        } else {
            return "add";
        }
    }

    @RequestMapping("/checkTitle")
    @ResponseBody
    public String checkTitle(String title) {
        VoteSubject voteSubject = vs.titleVote(title);
        if (voteSubject == null) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping("/joinVote")
    public String joinVote(@RequestParam Map<String, Object> map, Model mm) {
        String titleId = map.get("titleId").toString();
        int id = Integer.valueOf(titleId);
        List<VoteOption> joinVoteList = vs.joinVote(id);
        mm.addAttribute("m", map);
        mm.addAttribute("joinVoteList", joinVoteList);
        return "vote";
    }

    @RequestMapping("/joinedVote")
    public String joinedVote(@RequestParam Map<String, Object> map, VoteItem vi, String[] voteItem, HttpSession ss) {
        int num = 0;
        Users user = (Users) ss.getAttribute("user");
        for (int i = 0; i < voteItem.length; i++) {
            vi.setVo_id(Integer.valueOf(voteItem[i]));
            vi.setVu_user_id(user.getVu_user_id());
            vi.setVs_id(Integer.valueOf(map.get("titleId").toString()));
            num = vs.addVoteCount(vi);

        }
        if (num > 0) {
            return "forward:/findAll";
        } else {
            return "forward:/joinVote";
        }
    }

    @RequestMapping("/voteContent")
    public String voteContent(@RequestParam Map<String, Object> map, Model mm) {
        String titleId = map.get("titleId").toString();
        int id = Integer.valueOf(titleId);
        List<Map<String, Object>> optionsMapList = vs.findById(id);
        mm.addAttribute("optionsMap", optionsMapList);
        mm.addAttribute("contentMap", map);
        return "voteview";
    }

    @RequestMapping("/updateVote")
    public String updateVote(@RequestParam Map<String, Object> map, Model mm) {
        String titleId = map.get("titleId").toString();
        int id = Integer.valueOf(titleId);
        List<Map<String, Object>> optionsMapList = vs.findById(id);
        mm.addAttribute("optionsMap", optionsMapList);
        mm.addAttribute("contentMap", map);
        return "update";
    }

    @RequestMapping("/maintainVote")
    public String maintainVote(String userId, VoteSubject vss, String[] voOption, String[] voOptionId) {
        VoteOption vv = new VoteOption();
        vv.setVs_id(vss.getVs_id());
        List<VoteOption> voteOptions = vs.allVoteOption(vv);
        int addNum = 0;
        int delNum = 0;
        int del1Num = 0;
        int modifyNum = 0;
        if (voOption.length==voteOptions.size()){
            for (int i = 0; i < voOption.length; i++) {
                vv.setVo_id(voteOptions.get(i).getVo_id());
                vv.setVo_option(voOption[i]);
                modifyNum = vs.modifyVo(vv);
            }
        }else if (voOption.length>voteOptions.size()){
            for (int i = 0; i < voOption.length; i++){
                if(i<voteOptions.size()){
                    vv.setVo_id(voteOptions.get(i).getVo_id());
                    vv.setVo_option(voOption[i]);
                    modifyNum = vs.modifyVo(vv);
                }else {
                    vv.setVo_option(voOption[i]);
                    vv.setVo_id(Integer.valueOf(voOptionId[i]));
                    vv.setVo_order(voteOptions.get(voteOptions.size()-1).getVo_order()+1);
                    addNum = vs.addVo(vv);
                }
            }

        }else{
            for (int i = 0; i < voteOptions.size(); i++) {
                if(i<voOption.length){
                    vv.setVo_id(voteOptions.get(i).getVo_id());
                    vv.setVo_option(voOption[i]);
                    modifyNum = vs.modifyVo(vv);
                }else {
                    vv.setVo_option(voteOptions.get(i).getVo_option());
                    vv.setVo_id(voteOptions.get(i).getVo_id());
                    vv.setVo_order(voteOptions.get(voteOptions.size()-1).getVo_order()+1);
                    VoteItem voteItem = new VoteItem();
                    voteItem.setVs_id(vss.getVs_id());
                    voteItem.setVo_id(voteOptions.get(i).getVo_id());
                    delNum = vs.delVi(voteItem);
                    del1Num = vs.delVo(vv);
                }
            }
        }
        return "forward:/findAll";
    }

    @RequestMapping("/usersVote")
    @ResponseBody
    public String usersVote(@RequestParam Map<String, Object> map) {
        List<Map<String,Object>> vvVotesList = vs.usersVote(Integer.valueOf(map.get("vu_user_id").toString()),Integer.valueOf(map.get("vs_id").toString()));
        if (vvVotesList.size()==0){
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping("/deleteVote")
    public String deleteVote(String titleId){
        vs.delVoteItem(Integer.valueOf(titleId));
        vs.delVoteOption(Integer.valueOf(titleId));
        vs.delVoteSubject(Integer.valueOf(titleId));
        return "forward:/findAll";
    }
    @RequestMapping("/userCancel")
    public String userCancel(HttpSession ss){
        ss.removeAttribute("user");
        ss.getServletContext().removeAttribute("user");
        return "login";
    }
}
