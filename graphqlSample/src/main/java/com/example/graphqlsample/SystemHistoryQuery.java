package com.example.graphqlsample;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@GraphQLApi
@Component
@RequiredArgsConstructor
public class SystemHistoryQuery {
    private final JPAQueryFactory queryFactory;

    @GraphQLQuery
    @Transactional(readOnly = true)
    public List<SystemUseLog> GetSystemHistory() {
        List<stm_real_use_hstry> findDomainList = queryFactory
                .selectFrom(Qstm_real_use_hstry.stm_real_use_hstry)
                .fetch();

        return findDomainList
                .stream()
                .map(domain -> {
                    SystemUseLog log = new SystemUseLog();
                    log.setSystemKey(domain.getSiKey());
                    log.setGroupUserKey(domain.getGuKey());
                    log.setGroupKey(domain.getOgKey());
                    log.setStartDateTime(domain.getStrtDy());
                    log.setEndDateTime(domain.getEndDy());
                    return log;
                })
                .collect(Collectors.toList());
    }

    @GraphQLQuery(name = "system")
    @Transactional(readOnly = true)
    public CompletableFuture<SystemDto> getSystem(
            @GraphQLContext SystemUseLog systemUseLog,
            @GraphQLEnvironment ResolutionEnvironment env){
        DataLoader<Long, SystemDto> loader = env.dataFetchingEnvironment.getDataLoader(SystemDataLoader.NAME);
        return loader.load(systemUseLog.getSystemKey());
    }

    @GraphQLQuery(name = "user")
    @Transactional(readOnly = true)
    public CompletableFuture<UserDto> getUser(
            @GraphQLContext SystemUseLog systemUseLog,
            @GraphQLEnvironment ResolutionEnvironment env){
        DataLoader<Long, UserDto> loader = env.dataFetchingEnvironment.getDataLoader(UserDataLoader.NAME);
        return loader.load(systemUseLog.getGroupUserKey());
    }
}
