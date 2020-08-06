import dao.UserDAO;
import model.User;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class crudTest {

    private static final String UPDATED_EMAIL = "updated@e.mail";
    private static UserDAO dao;
    private static User expectedUser;

    @BeforeClass
    public static void before() {
        dao = new UserDAO();
        expectedUser = new User("Roman", "r@g.c", "Bel");
    }

    @Test
    public void T01_Create_Test() throws SQLException {
        User actualUser = dao.create(expectedUser);
        expectedUser.setId(actualUser.getId());
        Assert.assertEquals("Created user doesn't equal", expectedUser.toString(), actualUser.toString());
    }

    @Test
    public void T02_Select_Test() {
        User actualUser = dao.get(expectedUser.getId());
        Assert.assertEquals("Selecting error", expectedUser.toString(), actualUser.toString());
    }

    @Test
    public void T03_Update_Test() {
        expectedUser.setEmail(UPDATED_EMAIL);
        User actualUser = dao.update(expectedUser);
        Assert.assertEquals("Updating error", expectedUser.toString(), actualUser.toString());
    }

    @Test
    public void T04_Delete_Test() throws SQLException {
        Assert.assertTrue("Deleting error", dao.delete(expectedUser.getId()));
        Assert.assertNull("Deleting error", dao.get(expectedUser.getId()));
    }

    @Test
    public void T05_Select_all_Test() {
        List<User> expectedUsers = dao.listAll();
        List<User> actualUsers = new ArrayList<>();
        for (int i = 1;; i++) {
            User actualUser = dao.get(i);
            if (actualUser == null) {
                break;
            }
            final int index = i;
            User expectedFromList = expectedUsers.stream().filter(user -> user.getId() == index).findFirst().get();
            actualUsers.add(dao.get(i));
            Assert.assertEquals(String.format("User with id [%s] is not as expected", i),
                    expectedFromList.toString(), actualUser.toString());
        }
        Assert.assertEquals("Selecting all error",expectedUsers.size(),actualUsers.size());
    }

}
