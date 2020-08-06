import decorator.*;
import decorator.html.*;
import org.junit.Test;
import utils.JaxbUtils;

import java.util.Arrays;

public class decoratorTest {

    @Test
    public void createTrTest() {
        TdHtml tdName = new TdHtml("Name");
        TdHtml tdEmail = new TdHtml("Email");
        TdHtml tdCountry = new TdHtml("Country");
        TdHtml tdActions = new TdHtml(Arrays.asList(ButtonHtml.builder().button("Edit").build(),
                ButtonHtml.builder().button("Delete").build()));
        UsersRowHtml tr = new UsersRowHtml(Arrays.asList(tdName, tdEmail, tdCountry, tdActions));
        System.out.println(JaxbUtils.convertXmlObjectToString(tr));
    }


    @Test
    public void createBuilderTest() {
        TdHtml tdActions = TdHtml.builder().build();
        UsersRowHtml tr = new UsersRowHtml(Arrays.asList(tdActions));
        System.out.println(JaxbUtils.convertXmlObjectToString(tr));
    }


    @Test
    public void insertFormHtml() {
        System.out.println(UserFormDecorator.newUserForm());
    }


}
