package ru.stqa.pft.addressbook.tests;


import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;



public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object []> validGroups() throws IOException {
    List<Object []> list = new ArrayList<Object []>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line != null){
      String [] split =  line.split(";");
      list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
   //   GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
      app.goTo().groupPage();
      Groups before = app.getGroupHelper().all();

      app.getGroupHelper().create(group);

      assertThat(app.getGroupHelper().count(),equalTo(before.size() + 1));
      Groups after = app.getGroupHelper().all();
      assertThat(after, equalTo(before.withAdded(group.withId
              (after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

}

  @Test
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.getGroupHelper().all();

    GroupData group = new GroupData().withName("test2'");
    app.getGroupHelper().create(group);
    assertThat(app.getGroupHelper().count(),equalTo(before.size()));
    Groups after = app.getGroupHelper().all();

    assertThat(after, equalTo(before));
  }

}
