package com.plularsight.hibernatefundamentals;

import com.plularsight.hibernatefundamentals.airport.Airport;
import com.plularsight.hibernatefundamentals.airport.Passenger;
import com.plularsight.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Airport airport = new Airport(1, "CSMT");
        Passenger p1 = new Passenger(1, "Harshad Vele");
        p1.setAirport(airport);

        Passenger p2 = new Passenger(2, "Vishal Kshatriya");
        p2.setAirport(airport);

        airport.addPassengers(p1);
        airport.addPassengers(p2);

        Ticket ticket1 = new Ticket(1, "AAA123");
        ticket1.setPassenger(p1);

        Ticket ticket2 = new Ticket(2, "ABC798");
        ticket2.setPassenger(p2);

        p1.addTickets(ticket1);
        p2.addTickets(ticket2);

        Ticket ticket3 = new Ticket(3, "LOP159");
        ticket3.setPassenger(p2);
        p2.addTickets(ticket3);

        em.persist(airport);
        em.persist(p1);
        em.persist(p2);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();
        emf.close();

    }

}
