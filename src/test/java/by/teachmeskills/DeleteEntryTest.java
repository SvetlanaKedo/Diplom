package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.WorkingPage;

import by.teachmeskills.page.WritingPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteEntryTest extends BaseTest {

    @Test
    public void deleteEntry() {
        new LoginPage(driver).open().loginAsStandardUser().createEntry();
        final String expNote = "test";
        new WritingPage(driver).writeNote(expNote);
        new WritingPage(driver).deleteNote();
        boolean entryDeleted = new WorkingPage(driver).isEntryDeleted();
        assertThat(entryDeleted).as("Notes don't deleted").isTrue();
    }
}
