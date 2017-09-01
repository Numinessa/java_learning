package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupModificationTests extends TestBase {

@BeforeMethod
public void ensurePreconditions(){
  app.goTo().groupPage();
  if (app.getGroupHelper().all().size() == 0) {
    app.getGroupHelper().create(new GroupData().withName("test1"));
  }

}

  @Test
  public void testGroupModification(){

    Groups before = app.getGroupHelper().all();
    GroupData modifiedGroup = before.iterator().next();

    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.getGroupHelper().modify(group);
    Groups after = app.getGroupHelper().all();
    assertEquals(after.size(), before.size() );


    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
