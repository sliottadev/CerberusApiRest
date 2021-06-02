package TestRepo;

import com.cerberus.models.UserTest;
import com.cerberus.repositories.UserRepoDemo;

public class RepoTest {

	public static void main(String[] args) {
	
		UserRepoDemo repo = new UserRepoDemo();
		
		//Agregamos primer Usuario
		repo.addUser(new UserTest(1L, "Sebastian", "Argentina"));
		repo.addUser(new UserTest(2L, "Matias", "Argentina"));
		repo.addUser(new UserTest(3L, "Matias", "Argentina"));
		repo.addUser(new UserTest(4L, "Gerald", "Argentina"));
		
		//ImprmimosLista
		for(UserTest u:repo.getUsers()) {
			System.out.println(u.toString());
		}
	}

}
