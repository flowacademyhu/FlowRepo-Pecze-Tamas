package hu.flowacademy.shoppinglist.exception;

public class ListItemNotFoundExeption extends RuntimeException {

    public ListItemNotFoundExeption(String id) {
        super("Az elem nme talalhato a listaban. " + id);
    }
}
