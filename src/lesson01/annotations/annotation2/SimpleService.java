package lesson01.annotations.annotation2;

@Service(name = "NameOfSimpleService")
public class SimpleService {
    @Init
    public void initService(){
        System.out.println(this.getClass().getSimpleName());
    }

    public void secondMethod(){
        System.out.println("empty method");
    }
}
