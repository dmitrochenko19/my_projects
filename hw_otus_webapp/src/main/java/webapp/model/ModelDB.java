package webapp.model;

import webapp.entilities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ModelDB {
    private String url = "your_url";
    private String nameConn = "your_name";
     private String password = "your_password";
     public void addUser(User user) throws Exception{
         Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
         try(Connection conn  = DriverManager.getConnection(url,nameConn,password)){
             PreparedStatement st =conn.prepareStatement("insert into users_servlet.users_info(name,date, sex,age)" +
                     "values(?,?,?,?)");
             st.setString(1,user.getName());
             Calendar date  = user.getBirthDateCalendar();
             Date dateSql = new Date(date.getTimeInMillis());
             st.setDate(2,dateSql);
             st.setString(3, user.getSex());
             st.setInt(4,user.getAge());

             st.execute();
         }
     }
     public List<User> getUsers() throws Exception{
         List<User> users = new ArrayList<>();
         Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        try(Connection conn  = DriverManager.getConnection(url,nameConn,password)){
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("select * from users_servlet.users_info");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthDate = resultSet.getDate("date");
                String sex = resultSet.getString("sex");
                users.add(new User(name,birthDate,sex,age));
            }
        }
        return users;

     }
     public boolean updateUser(String oldName,String newName, Date newDate, String newSex, int newAge)throws Exception{
         Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
         try(Connection conn  = DriverManager.getConnection(url,nameConn,password)){
             PreparedStatement st = conn.prepareStatement("update users_servlet.users_info set name = ?,date = ?, sex = ?, age = ?  where name = ?");
             st.setString(1,newName);
             st.setDate(2,newDate);
             st.setString(3,newSex);
             st.setInt(4,newAge);
             st.setString(5,oldName);
             return st.execute();
         }
     }
     public void deleteUser(String name, String sex, String date) throws Exception{
         User user = new User(name,date,sex);
         Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
         try(Connection conn  = DriverManager.getConnection(url,nameConn,password)) {
            PreparedStatement st = conn.prepareStatement("delete from users_servlet.users_info where name = ? and date = ? and sex = ?");
            st.setString(1,user.getName());
            st.setDate(2,user.getBirthDateSQL());
            st.setString(3,user.getSex());
            st.execute() ;
         }

     }
    public int getMediumAge() throws Exception{
        int sum = 0;
        List<User> allUsers = getUsers();
        if(allUsers.size()==0)
            return 0;
        for(User user : allUsers){
            sum+=user.getAge();
        }
        return sum/allUsers.size();
    }
}
