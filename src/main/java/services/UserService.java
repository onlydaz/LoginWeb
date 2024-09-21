package services;

import dao.IUserDao;
import dao.UserDaolmpl;
import models.UserModel;

public class UserService implements IUserService{
	IUserDao userDao = new UserDaolmpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findUserName(username);
	    
	    if (user != null) {
	        if (password.equals(user.getPassword())) {
	            return user;
	        }
	    }
	    return null;

	}

	@Override
	public UserModel findUserName(String username) {
		return userDao.findByUserName(username);
	}

}
