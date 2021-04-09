package com.smilyk.telegrambot.javarushclient;


import com.smilyk.telegrambot.javarushclient.dto.GroupDiscussionInfo;
import com.smilyk.telegrambot.javarushclient.dto.GroupInfo;
import com.smilyk.telegrambot.javarushclient.dto.GroupRequestArgs;
import com.smilyk.telegrambot.javarushclient.dto.GroupsCountRequestArgs;

import java.util.List;

/**
 * Client for Javarush Open API corresponds to Groups.
 */
public interface JavaRushGroupClient {

    /**
     * Get all the {@link GroupInfo} filtered by provided {@link GroupRequestArgs}.
     *
     * @param requestArgs provided {@link GroupRequestArgs}.
     * @return the collection of the {@link GroupInfo} objects.
     */
    List getGroupList(GroupRequestArgs requestArgs);

    /**
     * Get all the {@link GroupDiscussionInfo} filtered by provided {@link GroupRequestArgs}.
     *
     * @param requestArgs provided {@link GroupRequestArgs}
     * @return the collection of the {@link GroupDiscussionInfo} objects.
     */
    List getGroupDiscussionList(GroupRequestArgs requestArgs);

    /**
     * Get count of groups filtered by provided {@link GroupRequestArgs}.
     *
     * @param countRequestArgs provided {@link GroupsCountRequestArgs}.
     * @return the count of the groups.
     */
    Integer getGroupCount(GroupsCountRequestArgs countRequestArgs);

    /**
     * Get {@link GroupDiscussionInfo} by provided ID.
     *
     * @param id provided ID.
     * @return {@link GroupDiscussionInfo} object.
     */
    GroupDiscussionInfo getGroupById(Integer id);
}
