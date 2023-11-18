package com.briup.ch08;

import java.lang.String;

import java.util.*;

/**
 * @Author briup-adam
 * @Date 2023/10/17 上午8:25
 * @Description 斗地主
 **/

public class PlayCard {
    //存储扑克牌
    private static List<Card> cards = new ArrayList();
    private static final String[] kinds = {"♥", "♠", "♣", "♦"};
    private static final String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    private static final Map<String, List> map = new HashMap();


    //生成扑克
    public static void makeCards() {
        for (String kind : kinds) {
            for (int i = 0; i < numbers.length; ) {
                Card card = new Card(kind, numbers[i], ++i);
                cards.add(card);
            }
        }
        cards.add(new Card("大", "🤡", 15));
        cards.add(new Card("小", "🤡", 14));
    }

    //洗牌
    public static void shuffle() {
        Collections.shuffle(cards);
    }

    //摸牌
    public static void deal(String player1, String player2, String player3) {
        //保存用户手牌的集合
        ArrayList player1Cards = new ArrayList();
        ArrayList player2Cards = new ArrayList();
        ArrayList player3Cards = new ArrayList();
        //总的摸牌次数
        for (int i = 0; i < cards.size() - 3; i++) {
            //交替摸牌
            switch (i % 3) {
                case 1:
                    player1Cards.add(cards.get(i));
                    break;
                case 2:
                    player2Cards.add(cards.get(i));
                    break;
                case 0:
                    player3Cards.add(cards.get(i));
                    break;
            }
        }
        map.put(player1, player1Cards);
        map.put(player2, player2Cards);
        map.put(player3, player3Cards);
        //获取底牌
        map.put("bottomCards", cards.subList(cards.size() - 3, cards.size()));
    }


    public static void cat() {
        //遍历map
        Set<Map.Entry<String, List>> entries = map.entrySet();
        for (Map.Entry<String, List> entry : entries) {
            System.out.println(entry.getKey());
            //给集合排序
            Collections.sort(entry.getValue());
            System.out.println(entry.getValue());
        }

    }

    public static void main(String[] args) {
        makeCards();
        shuffle();
        deal("果冻", "果汁", "果粒");
        cat();
    }

}

class Card implements Comparable<Card> {
    private String kind;
    private String number;
    private int val;

    public Card(String kind, String number, int val) {
        this.kind = kind;
        this.number = number;
        this.val = val;
    }

    @Override
    public String toString() {
        return kind + number;
    }

    @Override
    public int compareTo(Card o) {
        return -(this.val - o.val);
    }
}
