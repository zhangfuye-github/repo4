package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
	@Query(value = "select * from tb_problem a,tb_pl b  where a.id=b.problemid and  b.labelid=? order by replytime DESC",nativeQuery = true)
    public Page<Problem> newList(String labelid, Pageable pageable);
    @Query(value = "select * from tb_problem a,tb_pl b  where a.id=b.problemid and  b.labelid=? order by reply DESC",nativeQuery = true)
    public Page<Problem> hotList(String labelid, Pageable pageable);
    @Query(value = "select * from tb_problem a,tb_pl b  where a.id=b.problemid and  b.labelid=? and reply=0 order by createtime DESC",nativeQuery = true)
    public Page<Problem> waitList(String labelid, Pageable pageable);

}
