package lesson1.annotations;

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
