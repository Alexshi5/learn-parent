package sanguo.sort;

/**
 * author Alex
 * date 2018/6/24
 * description 人的实体类
 */
public class Person implements Comparable<Person> {

    private Integer id;//唯一标识

    private String name;//姓名

    private Integer fightValue;//战斗力值

    private Integer contribute;//贡献值

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFightValue() {
        return fightValue;
    }

    public void setFightValue(Integer fightValue) {
        this.fightValue = fightValue;
    }

    public Integer getContribute() {
        return contribute;
    }

    public void setContribute(Integer contribute) {
        this.contribute = contribute;
    }

    public Person(Integer id, String name, Integer fightValue, Integer contribute) {
        this.id = id;
        this.name = name;
        this.fightValue = fightValue;
        this.contribute = contribute;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fightValue=" + fightValue +
                ", contribute=" + contribute +
                '}';
    }

    @Override
    public int compareTo(Person o) {

        return  o.fightValue - this.fightValue;//降序
    }
}
