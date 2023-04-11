package library;

public interface IUser {

	public boolean loginAccount(User user);

	public void createAccount(User user);

	public void deleteAccount(User user);

	public void searchUser(String userName);

	public void listUsers();

}
