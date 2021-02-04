package cn.tedu.entity;

public class Hero {
    private int id;
    private String name;
    private String type;
    private int money;

    public Hero(int id, String name, String type, int money) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money +
                '}';
    }
}
