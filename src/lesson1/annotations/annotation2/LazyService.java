package lesson1.annotations.annotation2;

@Service(name = "NameOfLazyService")
public class LazyService {
    private int pri = 111;

    @Init
    public void lazyInit() throws Exception{
        System.out.println(this.getClass().getSimpleName());
    }
}
