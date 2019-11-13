package packsge1112;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class card {
    public String suit;
    public int rank;

    public card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d]",suit,rank);
    }
}

class CardDemo {
    public static final String[] SUITS = {"♠","♦","♥","♣"};

    public List<card> buyDeck() {
        List<card> cards = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = SUITS[i];
                //int rank = j;
                card card = new card(suit,j);
                cards.add(card);
            }
        }
        return cards;
    }

    private void swap(List<card> cards, int i, int index) {
        card tmp = cards.get(i);
        cards.set(i,cards.get(index));
        cards.set(index,tmp);
    }
    public void shuffle(List<card> cards) {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(cards,i,index);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<card> cards = cardDemo.buyDeck();
        System.out.println(cards);
        System.out.println("after shuffle");
        cardDemo.shuffle(cards);
        System.out.println(cards);

        //建三副牌
        List<List<card>> list = new ArrayList();
        List<card> list1 = new ArrayList<>();
        List<card> list2 = new ArrayList<>();
        List<card> list3 = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);


        //i牌数，j人数
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                card removecard = cards.remove(0);
                list.get(j).add(removecard);
            }
        }
        System.out.println("man1");
        System.out.println(list1);
        System.out.println("man2");
        System.out.println(list2);
        System.out.println("man3");
        System.out.println(list3);
    }
}
