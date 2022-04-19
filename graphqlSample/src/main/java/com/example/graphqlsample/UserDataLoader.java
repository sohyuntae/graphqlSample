package com.example.graphqlsample;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.dataloader.BatchLoader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements BatchLoader<Long, UserDto> {
    public static final String NAME = "userLoader";
    private final JPAQueryFactory queryFactory;

    @Override
    public CompletionStage<List<UserDto>> load(List<Long> keys) {
        List<grp_usr> findDomain = queryFactory
                .selectFrom(Qgrp_usr.grp_usr)
                .where(Qgrp_usr.grp_usr.guKey.in(keys))
                .fetch();

        List<Long> userKeyList = findDomain
                .stream()
                .map(grp_usr::getUiKey)
                .collect(Collectors.toList());

        Map<Long, grp_usr> groupUserDomainMap = findDomain
                .stream()
                .collect(Collectors.toMap(grp_usr::getGuKey, Function.identity()));

        Map<Long, usr_info> userDomainMap = queryFactory
                .selectFrom(Qusr_info.usr_info)
                .where(Qusr_info.usr_info.uiKey.in(userKeyList))
                .stream()
                .collect(Collectors.toMap(usr_info::getUiKey, Function.identity()));

        return CompletableFuture.completedFuture(keys
                .stream()
                .map(key -> {
                    grp_usr groupUserDomain = groupUserDomainMap.get(key);
                    if (groupUserDomain == null) return null;
                    usr_info userDomain = userDomainMap.get(groupUserDomain.getUiKey());
                    if (userDomain == null) return null;

                    UserDto user = new UserDto();
                    user.setGroupKey(groupUserDomain.getOgKey());
                    user.setGroupUserKey(groupUserDomain.getGuKey());
                    user.setUserKey(groupUserDomain.getUiKey());
                    user.setUserName(userDomain.getUiNm());
                    return user;
                })
                .collect(Collectors.toList())
        );
    }
}
