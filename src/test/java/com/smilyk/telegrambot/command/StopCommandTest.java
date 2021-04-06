package com.smilyk.telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.smilyk.telegrambot.command.CommandName.STOP;
import static com.smilyk.telegrambot.command.StopCommand.STOP_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}