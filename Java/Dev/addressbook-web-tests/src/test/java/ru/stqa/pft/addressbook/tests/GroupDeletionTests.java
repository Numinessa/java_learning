package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.getGroupHelper().all().size() == 0) {
      app.getGroupHelper().create(new GroupData().withName("test1"));
    }

  }

  @Test
  public void testGroupDeletion() {

    Groups before = app.getGroupHelper().all();
    GroupData deletedGroup = before.iterator().next();
    app.getGroupHelper().delete(deletedGroup);

    assertThat(app.getGroupHelper().count(),equalTo(before.size() - 1));
    Groups after = app.getGroupHelper().all();
    assertThat(after, equalTo(before.without(deletedGroup)));


  }

}
