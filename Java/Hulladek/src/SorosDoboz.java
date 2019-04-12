public class SorosDoboz extends Hulladek implements Ujrahasznosithato {

    public SorosDoboz(String leiras) {
        super("fem");
        setLeiras(leiras);
    }

    @Override
    public void ujrahasznosit() {
        System.out.println(getAlapanyag());
    }

    @Override
    public void megsemmisit() {
        super.megsemmisit();
        ujrahasznosit();
    }
}
