package transformer;

import org.openqa.selenium.WebElement;
import wrapper.Wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Transformer {
    private static Transformer ourInstance = new Transformer();

    public static Transformer getInstance() {
        return ourInstance;
    }

    private Transformer() {}

    public List<Wrapper> getList(List<WebElement> elements, final Function<WebElement, Wrapper> function) {
        final List<Wrapper> list = new ArrayList<>();
        elements.forEach(e -> list.add(function.apply(e)));
        return list;
    }

}
