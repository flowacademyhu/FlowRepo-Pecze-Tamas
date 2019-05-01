1. Mi lesz eredmény?

Class A {
	public static void parse(String str) {
		try {
			float f = Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			f = 0;
		} finally {
			System.out.println(f);
		}
	}

	public static void main(String[] args) {
		parse("invalid");
	}
}
Forditasi hiba!!! mivel a float f a catchben es a finallyben nem lathato, csak a tryban!
Hibasan válaszoltam: NumberFormatExeption + 0

2.Hogyan lehet a Nav osztály, Direction enum-ját példányosítani?

class Nav {
	public enum Direction { NORTH, SOUTH, EAST, WEST }
}

public class Sprite{
// insert code here
}

a. Direction d = NORTH;
b. Nav.Direction d = NORTH;
c. Direction d = Direction.NORTH;
d. Nav.Direction d = Nav.Direction.NORTH;

helyes válasz a D). Van két class, az enu a navon belül van definialva. Másik osztályban van és direkten nem lehet rá hivatkozni, így kell a Nav elé.

3.Mit ír ki az alábbi program?

public class StringRef 
{
    public static void main(String [] args) 
    {
        String a = "ab";
        String b = "cd";
        String c = b;
        b = "ef";
        System.out.println(a + b + c);
    }
}

Output: abefcd . a String nem változtatható adattipus b egyenlő ef, akkor hoz új változót létre.

4. Lehet-e egy interface final? nem . Pont hogy mindig felül kell deifiniálni, az a lényege az interfacenek.
5. Definiálható-e interface osztályon belül? Igen. lehet belül is kis private interfacet csinálni igy osztályon belül lehet belső láthatóságú interfacet csinálni. Osztályt is lehet osztályon belül létrehozni.
6. Öröklődéskor mi történik az ősosztály konstruktorával? Superrel tudunk rá hivatkozni. 
6.1 Amikor definiálunk tömböket, hány dimenziója lehet a tömbnek maximum? ([][][][][]) 255 a helyes valasz, mivel byte szinten van definialva.

7.Mit ír ki az alábbi program?

class Test {

   private static int a;

   public static void main(String args[]) {
       System.out.println(f());
   }

   static int f() {
       return ++a;
   }

}
Van különbség a prefix és a postfix között. Az összes primitiv alaperteke az 0. A nem primitiveké pedig null.
Output: 1

8. 1. Mire való a "garbage collection"? //garbage collector ami csinalja, ez pedig maga az esemeny

	Felszabaditja a használaton kívüli memóriaterüelteket, melyek korábban lefoglalásra kerültek a program futása alapján.
	Csak objektumok tünnek el. A primitivek nem, mivel azok máshol vannak. Ahol le van foglalva a memória, de nem mutat rá már semmi!!!


9. Mi a különbség a Map és a HashMap között?

Ezek interface-ek. A Hashmap egy megvalósítása a Map interfacenek.

10. Mi a "final"? 

Nem lehet módosítani.

11. Mit ír ki az alábbi program?

public class BoolTest 
{
    public static void main(String [] args) 
    {
        int result = 0;

        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRuE");
        Boolean b4 = new Boolean("false");

        if (b1 == b2) 
            result = 1;
        if (b1.equals(b2) ) 
            result = result + 10;
        if (b2 == b4)  
            result = result + 100;
        if (b2.equals(b4) )
            result = result + 1000;
        if (b2.equals(b3) )
            result = result + 10000;

        System.out.println(result);
    }
}

Az equals az értéket hasonlítja össze tehát azon átmegy. 10.010 a megoldás. Az ígylétrehozott boolean logikai értékű.

12, Kódolós feladat:
Adott egy nemnegatív egész számokból álló tömb, melynek az első elemén állunk. A tömb minden eleme az adott pozícióból történő legnagyobb ugorható távolságot jelöli. Döntsük el a tömbről, hogy el tudunk-e jutni benne az utolsó elemig a fenti szabályt követve. Példák: A = [2,3,1,1,4], eredménye igaz. B = [3,2,1,0,4], eredménye hamis.

for(int i = 0; i < A.size; i++) {

	

}

