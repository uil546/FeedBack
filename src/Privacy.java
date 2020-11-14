public class Privacy {
    String name;
    int age;
    private Privacy(String name,int age){
        this.name = name;
        this.age = age;
    }
    private void doorOpen(){
        System.out.println(name + "：是谁不敲门就进来？！");
    }
}
