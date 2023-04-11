package library;

public class UserManager implements IUser {

	private User[] users = new User[10];
	private int userCount = 0;

	@Override
	public boolean loginAccount(User user) {

		if (users[0] == null) {
			System.out.println("Kullanıcı bulunamadı.");
			return false;
		}

		if (equals(user)) {
			System.out.println("Giriş yapıldı !!!");
			return true;
		} else {
			System.out.println("Kullanıcı adı veya şifre hatalı !!!");
			return false;
		}
	}

	@Override
	public void createAccount(User user) {

		for (User userx : users) {
			if (userx == null) {
				users[userCount] = user;
				userCount++;
				System.out.println(user.getUserName() + " adlı kullanıcı eklendi.");
				break;
			} else {
				if (userx.getUserName().equalsIgnoreCase(user.getUserName())) {
					System.out.println("Kayıtlı Kullanıcı");
					break;
				}
			}
		}
	}

	@Override
	public void deleteAccount(User user) {

		int index = -1;
		for (int i = 0; i < userCount; i++) {
			if (users[i].getUserName().equalsIgnoreCase(user.getUserName())) {
				index = i;
				break;
			}
		}

		if (index != -1) {
			for (int i = 0; i < userCount; i++) {
				if (i == index) {
					for (int j = i; j < userCount; j++) {
						users[j] = users[j + 1];
					}
				}
			}
			users[userCount - 1] = null;
			userCount--;
			System.out.println(user.getUserName() + " adlı kullanıcı silindi.");
		} else {
			System.out.println("Kullanıcı bulunamadı");
		}
	}

	@Override
	public void listUsers() {
		for (User user : users) {
			if (user != null) {
				System.out.println(user);
			}
		}
		if (users[0] == null) {
			System.out.println("Kullanıcı bulunmamaktadır.");
		}
	}

	@Override
	public void searchUser(String userName) {

		boolean result = false;

		for (int i = 0; i < userCount; i++) {
			if (users[i].getUserName().equalsIgnoreCase(userName)) {
				System.out.println("[userName=" + users[i].getUserName() + ", password=" + users[i].getPassword()
						+ ", email=" + users[i].getEmail() + "]");
				result = true;
				break;
			}
		}
		if (result == false) {
			System.out.println(userName + " adlı kullanıcı bulunamadı.");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;

		for (User userx : users) {
			if (userx != null) {
				if (userx.getUserName().equals(other.getUserName())
						&& userx.getPassword().equals(other.getPassword())) {
					return true;
				}
			}
		}
		return false;
	}

}
