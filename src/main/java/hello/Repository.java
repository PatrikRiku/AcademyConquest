package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component

/**
 * Created by Bodsten on 2017-03-30.
 */

public class Repository implements IUser {

    @Autowired
    DataSource dataSource;


    public UserLogin getUserLogin(String Username, String Password) throws Exception {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT Username, Password FROM [dbo].[ACUser] WHERE Username= ? AND Password= ?")) {
            ps.setString(1, Username);
            ps.setString(2, Password);

            try (ResultSet rs = ps.executeQuery()) {

                if (!rs.next())
                    return null;
                else
                    return rsUserLogin(rs);
            } catch (SQLException e) {
                throw new Exception(e);
            }
        }
    }

    @Override
    public void addUser(String Username, String Password) throws Exception {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO [dbo].[ACUser](Username, Password)VALUES (?,?)", new String[]{"Id"})) {

            ps.setString(1, Username);
            ps.setString(2, Password);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception(e);
        }
    }


    private UserLogin rsUserLogin(ResultSet rs) throws SQLException {
        return new UserLogin(
                rs.getString("Username"),
                rs.getString("Password")

        );
    }

    /*public UserSignUp rsUser(ResultSet rs) throws SQLException {
        return new UserSignUp(

                rs.getString("Username"),
                rs.getString("Password")
        );
    }*/
}

