package cn.tedu.dao;

import cn.tedu.entity.Hero;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroDao {
    public void add(Hero hero){
        try (Connection conn= DBUtils.getConn()){
            String sql="insert into hero values(null,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,hero.getName());
            ps.setString(2,hero.getType());
            ps.setInt(3,hero.getMoney());
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Hero> findAll() {
        List<Hero> list=new ArrayList<>();
        try (Connection conn=DBUtils.getConn()){
            String sql="select id,name,type,money from hero";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String type=rs.getString(3);
                int money = rs.getInt(4);
//                把数据封装到Hero对象 把对象装进list集合
                list.add(new Hero(id,name,type,money));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteById(String id) {
        try (Connection coon=DBUtils.getConn()){
            String sql="delete from hero where id=?";
            PreparedStatement ps=coon.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(id));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Hero hero) {
        try (Connection conn=DBUtils.getConn()){
            String sql="update hero set name=?,type=?,money=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,hero.getName());
            ps.setString(2,hero.getType());
            ps.setInt(3,hero.getMoney());
            ps.setInt(4,hero.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
