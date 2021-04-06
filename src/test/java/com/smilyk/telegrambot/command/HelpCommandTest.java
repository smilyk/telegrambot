package com.smilyk.telegrambot.command;

import static com.smilyk.telegrambot.command.CommandName.HELP;
import static com.smilyk.telegrambot.command.HelpCommand.HELP_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;


@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
