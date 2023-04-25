package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.WorkingPage;

import by.teachmeskills.page.WritingPage;
import org.testng.annotations.Test;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class EntryTest extends BaseTest {

    @Test
    public void entryCreate() {
        new LoginPage(driver).open().loginAsStandardUser().isOpened();
        WritingPage entry = new WorkingPage(driver).createEntry();
        assertThat(entry.isOpened()).isTrue().as("Writing Page has not been opened");
        final String expNote = "4564564";
        new WritingPage(driver).writeNote(expNote);
        List<String> actNote = new WorkingPage(driver).getAllNameNotes();
        assertThat(actNote).as("Text" + expNote + "has not been displayed").contains(expNote);
    }


}