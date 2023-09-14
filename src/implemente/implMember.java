package implemente;

import DataBase.DB;
import bookjava.Book;
import bookjava.Member;
import interfaces.memberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Connection connection = DB.Connect();
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM membre";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String cin = rs.getString("cin");
            String phoneNumber = rs.getString("phoneNumber");

            Member member = new Member(id, name, cin, phoneNumber);
            members.add(member);
        }

        rs.close();
        ps.close();
        connection.close();

        return members;
    }

    @Override
    public Member insert(Member member) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "INSERT INTO membre (name , cin , phoneNumber ) VALUES ( ? , ? , ? )";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, member.getName());
        ps.setString(2, member.getCIN());
        ps.setString(3, member.getPhoneNumber());

        int rs = ps.executeUpdate();

        ps.close();
        connection.close();
        Member mb = getOne(member.getCIN());
        if (mb == null) {
            System.out.println("Member not found");
            return null;
        }
        return mb;
    }

    @Override
    public Member update(Member member) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "UPDATE membre SET name = ? , phoneNumber = ? WHERE cin = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, member.getName());
        ps.setString(2, member.getPhoneNumber());
        ps.setString(3, member.getCIN());
        int rs = ps.executeUpdate();

        ps.close();
        connection.close();
        Member mb = getOne(member.getCIN());
        if (mb == null) {
            System.out.println("member not found");
            return null;
        }
        return mb;
    }

    @Override
    public boolean delete(Member member) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean last = false;
        try {
            connection = DB.Connect();
            String sql = "DELETE FROM membre WHERE cin = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, member.getCIN());

            int rowCount = ps.executeUpdate();

            if (rowCount == 0) {
                last = false;
            } else {
                last = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return last;
    }
}
