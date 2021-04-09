package com.smilyk.telegrambot.javarushclient.dto;

import lombok.Data;

import lombok.Data;

/**
 * DTO for User discussion info.
 */
@Data
public class UserDiscussionInfo {

    private Boolean isBookmarked;
    private Integer lastTime;
    private Integer newCommentsCount;
}
