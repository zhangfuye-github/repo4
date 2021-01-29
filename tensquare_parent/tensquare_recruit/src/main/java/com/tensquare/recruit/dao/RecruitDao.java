package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    /**
     *
     * 推荐职位查询
     * @param s
     * @return
     */
    public List<Recruit> findTop3ByState(String s);

    /**
     *
     * @param s
     * @return
     */
    public List<Recruit> findTop3ByStateNotOrderByCreatetimeDesc(String s);
}
