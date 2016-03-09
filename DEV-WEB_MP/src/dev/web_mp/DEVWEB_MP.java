package dev.web_mp;

import dao.*;
import entity.*;
import java.util.ArrayList;

public class DEVWEB_MP {

    public static void main(String[] args) {
      
        UserDAO userDAO = new UserDAO();
        userDAO.SignIn(new User("solomon", "password"));
//        for(int i = 0; i < catlist.size(); i++)
//            System.out.println(catlist.get(i).getCategoryID()+"\t"+
//                    catlist.get(i).getCategoryName());
    }
    
}
