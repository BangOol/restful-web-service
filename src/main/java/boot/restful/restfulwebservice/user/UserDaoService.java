package boot.restful.restfulwebservice.user;


import boot.restful.restfulwebservice.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;
    static{
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "elice", new Date()));
        users.add(new User(3, "Elena", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User putById(int id){
        Iterator<User> userIterator = users.iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();

            if(user.getId() == id){
                // 해당 id가 있기 때문에 exception 발생시키거나 해야 될 듯?
            }
        }
        return null;
    }

}
