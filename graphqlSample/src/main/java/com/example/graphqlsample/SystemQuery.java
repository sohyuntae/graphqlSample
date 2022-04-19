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

@Component
@GraphQLApi
@RequiredArgsConstructor
public class SystemQuery {
    private final JPAQueryFactory queryFactory;

    @GraphQLQuery
    public List<SystemDto> getSystem() {
        List<stm_info> domainList = queryFactory
                .selectFrom(Qstm_info.stm_info)
                .fetch();

        return domainList
                .stream()
                .map(domain -> {
                    SystemDto system = new SystemDto();
                    system.setSystemKey(domain.getSiKey());
                    system.setGroupKey(domain.getOgKey());
                    system.setGroupUserKey(domain.getGuKey());
                    system.setSystemName(domain.getSiNm());
                    return system;
                })
                .collect(Collectors.toList());
    }

    @GraphQLQuery(name = "user")
    @Transactional(readOnly = true)
    public CompletableFuture<UserDto> getUser(
            @GraphQLContext SystemDto systemDto,
            @GraphQLEnvironment ResolutionEnvironment env){
        DataLoader<Long, UserDto> loader = env.dataFetchingEnvironment.getDataLoader(UserDataLoader.NAME);
        return loader.load(systemDto.getGroupUserKey());
    }
}
