package uz.coder.d2lesson68homework;

public class MahsulotModel {
    private String name;
    private int count;


    public MahsulotModel(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "MahsulotModel{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
