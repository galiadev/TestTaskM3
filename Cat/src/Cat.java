import java.util.Random;

public class Cat implements Cloneable
{

    /*
        Урок 4. Константы и Enum

            - Создать у кошки константы: “количество глаз”, “минимальный вес” и “максимальный вес”.
            - Создать enum с окрасами кошек.
    */
    private final int NUMBER_OF_EYES = 2;
    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;

    private CatCoatColor color = CatCoatColor.BLACK;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double totalEatenFood;

    private static int count = 0;
    private boolean hasTail = true;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }

    public Cat(Double weight)
    {
        this.weight = weight;
        originWeight = weight;
        minWeight = MIN_WEIGHT;
        maxWeight = MAX_WEIGHT;
        count++;
    }

    public void meow()
    {
        if(!isDead()){
            weight = weight - 1;
            System.out.println("Meow");
            if(isDead()){
                count--;
            }
        } else System.out.println("Sorry, cat is dead :(");
    }

    public void feed(Double amount)
    {
        if(!isDead()) {
            weight = weight + amount;
            totalEatenFood += amount;
            if (this.getStatus().equals("Exploded")) {
                count--;
            }
        } else System.out.println("Sorry, cat is dead :(");
    }

    public void drink(Double amount)
    {
        if(!isDead()) {
            weight = weight + amount;
            if (this.getStatus().equals("Exploded")) {
                count--;
            }
        } else System.out.println("Sorry, cat is dead :(");
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    /*
        Урок 2. Метод, параметры, return
            - Создать в классе Cat метод, который будет возвращать сумму съеденной еды текущей кошки
            - Создать в классе Cat метод “сходить в туалет” pee(), который будет уменьшать вес кошки и что-нибудь печатать.

        Рекомендации: протестируйте верную работу метода возврата съеденной еды:
            - создайте кошку
            - покормите кошку кормом весом 150.00
            - вызовите метод pee() несколько раз
            - распечатайте значение съеденного корма, в консоль должно напечататься 150.00
     */

    public Double getTotalEatenFood()
    {
        return totalEatenFood;
    }

    public void pee()
    {
        if(!isDead()) {
            weight = weight - 10;
            System.out.println("Pee-pee...");
            if (isDead()) {
                count--;
            }
        } else System.out.println("Sorry, cat is dead :(");
    }

    public static int getCount()
    {
        return count;
    }

    /*
        Урок 3. Статические методы и переменные
        Задание c *: придумайте способ проверять жива ли кошка или нет на основе значения ее веса, и используя это запретите кормить, пить, ходить в туалет неживой кошке.

        Лучше всего использовать уже существующий метод, чтобы не переписывать заново те же самые условия!
        Метод getStatus() уже проверяет жива кошка или нет на основе условия if(weight < minWeight) сравнения - текущего и минимального веса

        public boolean isDead(){
            return this.getStatus().equals("Dead");
        }

        Второй способ это согласно заданию: проверка жива ли кошка, используя вес кошки написать условие, но условие будет таким же как в методе getStatus() -  дублирование существующего кода

        public boolean isDead(){
            return weight < minWeight;
        }

        В задании неоднозначно считается ли взорвашаяся кошка мёртвой? поскольку мы отнимает взорвавшихся кошек - возможно, что считается
        Поэтому финальная версия проверочного метода будет следующей:
     */

    public boolean isDead()
    {
        return weight < minWeight || weight > maxWeight;
    }

    /*
        Урок 6. Инкапсуляция, геттеры и сеттеры**

            - Создать у кошки переменную в которой хранится окрас, написать геттер и сеттер для окраса.

        Рекомендации: имена методов, возвращающие значения полей типа boolean, принято именовать с префиксами is/has. Например:

            - метод возвращающий результат проверки “Жива ли кошка?” можно назвать isAlive(), если кошка жива - мы ожидаем возврат значение true
            - метод возвращающий результат проверки “Есть ли у кошки хвост?” можно назвать hasTail(), если кошка с хвостом - мы ожидаем возврат значение true
     */
    public CatCoatColor getColor() { return color; }
    public void setColor(CatCoatColor color){ this.color = color; }

    public boolean isAlive(){ return !isDead();}
    public boolean hasTail(){ return hasTail; }

    /*
        Урок 7. Копирование объектов

            - Создать у кошки метод создания её “глубокой” копии. Для создания копии кошки вы можете использовать метод копирования или конструктор копирования.
    */

    public Cat copy(Cat cat){
        Cat catClone = new Cat();
        this.weight = cat.weight;
        this.color = cat.color;
        this.hasTail = cat.hasTail;
        this.originWeight = cat.originWeight;
        this.minWeight = cat.minWeight;
        this.maxWeight = cat.maxWeight;
        return catClone;
    }

    public Cat(Cat cat){
        this.weight = cat.weight;
        this.color = cat.color;
        this.hasTail = cat.hasTail;
        this.originWeight = cat.originWeight;
        this.minWeight = cat.minWeight;
        this.maxWeight = cat.maxWeight;
    }

    @Override
    public Object clone(){
        Cat cat = null;
        try{
            cat = (Cat) super.clone();
        } catch (CloneNotSupportedException e){
            cat = new Cat(this.weight);
        }
        cat.color = this.color;
        return cat;
    }
}