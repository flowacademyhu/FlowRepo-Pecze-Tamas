package hu.flowacademy.shoppinglist;

public class ListItemNotFoundExeption extends RuntimeException {

    public ListItemNotFoundExeption(String id) {
        super("Az elem nme talalhato a listaban. " + id);
    }
}
