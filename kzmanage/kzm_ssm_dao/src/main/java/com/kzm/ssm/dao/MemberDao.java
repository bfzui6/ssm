package com.kzm.ssm.dao;

import com.kzm.ssm.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
public interface MemberDao {
    Member findById(@RequestParam("memberid") String id)throws Exception;
}
