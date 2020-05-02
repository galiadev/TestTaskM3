
public class Loader
{
    /*
        Урок 5. Создание объектов и конструктор

            - Создать в классе Cat ещё один конструктор так, чтобы можно было создать кошку с весом переданным в конструктор
            - Создать в главном классе Loader метод генерации котенка private static Cat getKitten(), который будет возвращать кошку с весом 1100.00, используя конструктор в который передаем вес кошки, как описано в видеоуроке.
     */
    private static Cat getKitten(){
        return new Cat(1100.0);
    }

    public static void main(String[] args)
    {
        System.out.println("Количество живых кошек: " + Cat.getCount());

        Cat cat = new Cat();

        System.out.println(cat.getStatus());

        System.out.println("Количество живых кошек: " + Cat.getCount());

        /*
            Урок 1. Понятие класса и объекта

            Создать 5-7 кошек и вызвать у них различные методы:

              - напечатайте в консоль вес созданных кошек
              - покормите 2 кошки и после этого распечатать их вес (убедитесь что вес изменился)
              - перекормите кошку
              - "замяукайте" кошку до смерти

            Рекомендации: для достижения “перекорма” и “замяукивания” кошки возможно использовать цикл с условием проверки статуса кошки, чтобы лишнего не мяукать и не кормить
         */

        Cat murka = new Cat();
        Cat snezhok = new Cat();
        Cat garfild = new Cat();
        Cat iriska = new Cat();
        Cat musya = new Cat();
        Cat sima = new Cat();
        Cat winki = new Cat();

        System.out.println("Количество живых кошек: " + Cat.getCount());

        // напечатайте в консоль вес созданных кошек
        System.out.println("Murka: weight " + murka.getWeight());
        System.out.println("Snezhok: weight " + snezhok.getWeight());
        System.out.println("Garfild: weight " + garfild.getWeight());
        System.out.println("Iriska: weight " + iriska.getWeight());
        System.out.println("Musya: weight " + musya.getWeight());
        System.out.println("Sima: weight " + sima.getWeight());
        System.out.println("Winki: weight " + winki.getWeight());

        System.out.println();

        // покормите 2 кошки и после этого распечатать их вес (убедитесь что вес изменился)
        murka.feed(10.);
        garfild.feed(100.5);
        System.out.println("Murka: weight " + murka.getWeight());
        System.out.println("Garfild: weight " + garfild.getWeight());
        System.out.println();

        // перекормите кошку
        while(!murka.getStatus().equals("Exploded")){
            murka.feed(10.0);
        }
        System.out.println("Murka: weight " + murka.getWeight() + ", status " + murka.getStatus());
        murka.meow();
        murka.pee();
        murka.feed(15.0);
        murka.drink(5.0);
        System.out.println();

        System.out.println("Количество живых кошек: " + Cat.getCount());

        // "замяукайте" кошку до смерти
        while (!winki.getStatus().equals("Dead")){
            winki.meow();
        }
        System.out.println("Winki: weight " + winki.getWeight() + ", status " + winki.getStatus());
        winki.meow();
        winki.pee();
        winki.feed(15.0);
        winki.drink(5.0);
        System.out.println();

        System.out.println("Количество живых кошек: " + Cat.getCount());

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

        Cat momo = new Cat();
        momo.feed(150.0);
        momo.pee();
        momo.pee();
        System.out.println(momo.getTotalEatenFood());

    }
}