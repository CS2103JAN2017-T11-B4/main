package guitests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.task.logic.commands.RedoCommand;
import seedu.task.testutil.TestTask;
import seedu.task.testutil.TestUtil;

public class RedoCommandTest extends TaskListGuiTest {

    @Test
    public void redoSingle() {
        //redo while no history is present
        commandBox.runCommand("redo");
        assertResultMessage(RedoCommand.MESSAGE_NO_HISTORY);

        //undo add
        TestTask[] list = td.getTypicalPersons();
        commandBox.runCommand(td.hoon.getAddCommand());
        TestTask personToAdd = td.hoon;
        list = TestUtil.addPersonsToList(list, personToAdd);
        commandBox.runCommand("undo");
        commandBox.runCommand("redo");
        assertTrue(personListPanel.isListMatching(list));

        //redo while no more commands are present
        commandBox.runCommand("redo");
        assertResultMessage(RedoCommand.MESSAGE_NO_HISTORY);

    }

}
