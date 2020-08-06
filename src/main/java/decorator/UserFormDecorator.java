package decorator;

import decorator.html.*;
import model.User;
import utils.JaxbUtils;

import java.util.Arrays;

public class UserFormDecorator {

    public static String newUserForm() {
        InputHtml name = InputHtml.builder()
                .type("text")
                .placeholder("Name")
                .name("name")
                .required("required")
                .build();
        InputHtml email = InputHtml.builder()
                .type("text")
                .placeholder("Email")
                .name("email")
                .build();
        InputHtml country = InputHtml.builder()
                .type("text")
                .placeholder("Country")
                .name("country")
                .build();
        ButtonHtml button = ButtonHtml.builder()
                .type("submit")
                .button("Save")
                .build();
        FormHtml formHtml = FormHtml.builder()
                .action("insert")
                .method("post")
                .strong("Create New User")
                .input(Arrays.asList(name, email, country))
                .button(button)
                .build();
        return JaxbUtils.convertXmlObjectToString(formHtml);
    }

    public static String editUserForm(User user) {
        InputHtml id = InputHtml.builder()
                .type("hidden")
                .name("id")
                .value(String.valueOf(user.getId()))
                .required("required")
                .build();
        InputHtml name = InputHtml.builder()
                .type("text")
                .placeholder("Name")
                .name("name")
                .value(user.getName())
                .required("required")
                .build();
        InputHtml email = InputHtml.builder()
                .type("text")
                .placeholder("Email")
                .name("email")
                .value(user.getEmail())
                .build();
        InputHtml country = InputHtml.builder()
                .type("text")
                .placeholder("Country")
                .name("country")
                .value(user.getCountry())
                .build();
        ButtonHtml button = ButtonHtml.builder()
                .type("submit")
                .button("Save")
                .build();
        FormHtml formHtml = FormHtml.builder()
                .action("update")
                .method("post")
                .strong("Edit User")
                .input(Arrays.asList(id, name, email, country))
                .button(button)
                .build();
        return JaxbUtils.convertXmlObjectToString(formHtml);
    }

}
