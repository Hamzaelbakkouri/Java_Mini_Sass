package implemente;

import DataBase.DB;
import bookjava.Book;
import bookjava.Member;
import interfaces.memberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class implMember implements memberDAO {

    @Override
    public Member getOne(String cin) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "SELECT * FROM membre WHERE cin = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cin);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String phoneNumber = rs.getString("phoneNumber");

            Member membre = new Member(id, name, cin, phoneNumber);
            return membre;
        }
        rs.close();
        ps.close();
        connection.close();
        return null;
    }

    @Override
    public List<Member> getALL() throws SQLException {
        return null;
    }

    @Override
    public Member insert(Member member) throws SQLException {
        return null;
    }

    @Override
    public Member update(Member member) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(double isbn) throws SQLException {
        return false;
    }
}
