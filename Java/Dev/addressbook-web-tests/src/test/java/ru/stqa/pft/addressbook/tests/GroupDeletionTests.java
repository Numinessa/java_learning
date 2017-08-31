package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.getGroupHelper().List().size() == 0) {
      app.getGroupHelper().create(new GroupData().withName("test1"));
    }

  }

  @Test
  public void testGroupDeletion() {

    List<GroupData> before = app.getGroupHelper().List();
    int index = before.size() -1;
    app.getGroupHelper().delete(index);
    List<GroupData> after = app.getGroupHelper().List();
    Assert.assertEquals(after.size(), before.size() -1);


    before.remove(index);
      Assert.assertEquals(before, after);

  }

}
