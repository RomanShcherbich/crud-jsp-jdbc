package decorator;

import decorator.html.*;
import model.User;
import utils.JaxbUtils;

import java.util.Arrays;

public class UserListDecorator {

    private final static String EDIT_HREF = "edit?id=%s";
    private final static String DELETE_HREF = "delete?id=%s";

    public static String toHtml(User user) {
        String id = String.valueOf(user.getId());
        TdHtml tdId = new TdHtml(id);
        TdHtml tdName = new TdHtml(user.getName());
        TdHtml tdEmail = new TdHtml(user.getEmail());
        TdHtml tdCountry = new TdHtml(user.getCountry());
        TdHtml tdActions = TdHtml.builder().build();
        UsersRowHtml tr = new UsersRowHtml(Arrays.asList(tdId, tdName, tdEmail, tdCountry, tdActions));
        String editUserHref = String.format(EDIT_HREF, id);
        String deleteUserHref = String.format(DELETE_HREF, id);
        String htmlRow = String.format(JaxbUtils.convertXmlObjectToString(tr), editUserHref, deleteUserHref);
        return htmlRow;
    }

}
