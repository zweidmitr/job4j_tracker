package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws USerNotFoundException {
        for (User us : users) {
            if (us.getUsername().equals(login)) {
                return us;
            }
        }
        throw new USerNotFoundException("we did not find USer");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");

            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException en) {
            en.printStackTrace();
        } catch (USerNotFoundException ea) {
            ea.printStackTrace();
        }
    }
}