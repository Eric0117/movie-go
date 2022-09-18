package com.eric.moviego.repository.impl;

import com.eric.moviego.repository.MemberRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 16.
 **/
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

}
