package services;

import models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel findUserName(String username);
}
