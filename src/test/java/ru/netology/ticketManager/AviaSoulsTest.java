package ru.netology.ticketManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

class AviaSoulsTest {

    @Test
    public void testSortTicketsFewValues() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 300, 10, 19);
        Ticket ticket2 = new Ticket("Москва", "Владивосток", 200, 11, 20);
        Ticket ticket3 = new Ticket("Москва", "Астана", 700, 13, 16);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 500, 9, 19);
        Ticket ticket5 = new Ticket("Алматы", "Астана", 800, 8, 9);
        Ticket ticket6 = new Ticket("Москва", "Владивосток", 300, 6, 16);
        Ticket ticket7 = new Ticket("Нижний новгород", "Шымкент", 350, 10, 18);
        Ticket ticket8 = new Ticket("Москва", "Владивосток", 500, 7, 21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Ticket[] actual = manager.search("Москва", "Владивосток");

    }

    @Test
    public void testSortTicketsOneValue() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 300, 10, 19);
        Ticket ticket2 = new Ticket("Москва", "Владивосток", 200, 11, 20);
        Ticket ticket3 = new Ticket("Москва", "Астана", 700, 13, 16);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 500, 9, 19);
        Ticket ticket5 = new Ticket("Алматы", "Астана", 800, 8, 9);
        Ticket ticket6 = new Ticket("Москва", "Владивосток", 300, 6, 16);
        Ticket ticket7 = new Ticket("Нижний новгород", "Шымкент", 350, 10, 18);
        Ticket ticket8 = new Ticket("Москва", "Владивосток", 500, 7, 21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("Москва", "Астана");

    }

    @Test
    public void testSortTicketsNoFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 300, 10, 19);
        Ticket ticket2 = new Ticket("Москва", "Владивосток", 200, 11, 20);
        Ticket ticket3 = new Ticket("Москва", "Астана", 700, 13, 16);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 500, 9, 19);
        Ticket ticket5 = new Ticket("Алматы", "Астана", 800, 8, 9);
        Ticket ticket6 = new Ticket("Москва", "Владивосток", 300, 6, 16);
        Ticket ticket7 = new Ticket("Нижний новгород", "Шымкент", 350, 10, 18);
        Ticket ticket8 = new Ticket("Москва", "Владивосток", 500, 7, 21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Уфа");

    }

    @Test
    public void testSortTicketsFewValuesWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 300, 10, 19); // 9
        Ticket ticket2 = new Ticket("Москва", "Владивосток", 200, 12, 20); // 8
        Ticket ticket3 = new Ticket("Москва", "Астана", 700, 13, 16);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 500, 9, 19); // 10
        Ticket ticket5 = new Ticket("Алматы", "Астана", 800, 8, 9);
        Ticket ticket6 = new Ticket("Москва", "Владивосток", 300, 5, 16); // 11
        Ticket ticket7 = new Ticket("Нижний новгород", "Шымкент", 350, 10, 18);
        Ticket ticket8 = new Ticket("Москва", "Владивосток", 500, 7, 21); // 14

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket1, ticket4, ticket6, ticket8};
        Ticket[] actual = manager.search("Москва", "Владивосток", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketsOneValueWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 300, 10, 19); // 9
        Ticket ticket2 = new Ticket("Москва", "Владивосток", 200, 12, 20); // 8
        Ticket ticket3 = new Ticket("Москва", "Астана", 700, 13, 16);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 500, 9, 19); // 10
        Ticket ticket5 = new Ticket("Алматы", "Астана", 800, 8, 9);
        Ticket ticket6 = new Ticket("Москва", "Владивосток", 300, 5, 16); // 11
        Ticket ticket7 = new Ticket("Нижний новгород", "Шымкент", 350, 10, 18);
        Ticket ticket8 = new Ticket("Москва", "Владивосток", 500, 7, 21); // 14

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("Алматы", "Астана", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortTicketsNoFoundWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Владивосток", 300, 10, 19); // 9
        Ticket ticket2 = new Ticket("Москва", "Владивосток", 200, 12, 20); // 8
        Ticket ticket3 = new Ticket("Москва", "Астана", 700, 13, 16);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 500, 9, 19); // 10
        Ticket ticket5 = new Ticket("Алматы", "Астана", 800, 8, 9);
        Ticket ticket6 = new Ticket("Москва", "Владивосток", 300, 5, 16); // 11
        Ticket ticket7 = new Ticket("Нижний новгород", "Шымкент", 350, 10, 18);
        Ticket ticket8 = new Ticket("Москва", "Владивосток", 500, 7, 21); // 14

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Нижний новгород", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }
}