package org.nodyn;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

/**
 * Created by grayfox on 29/10/14.
 */
public class EJBMock {

    public EJBMock() {
        System.out.println("Calling EJBMock constructor");

        Method[] methods = this.getClass().getMethods();
        for(Method m : methods) {
            System.out.println("Method --> " + m.getName());
        }
    }

    private class Ticket {
        protected int ticketId;

        public int getTicketId() {
            return this.hashCode();
        }

        public void setTicketId(int id) {
            ticketId = id;
        }
    }

    public List<Ticket> fetchAllTickets() {
        List l = new ArrayList<Ticket>();
        for (int i = 0; i < 10; i++) {
            Ticket t = new Ticket();
            t.setTicketId(i);
            l.add(t);
        }
        return l;
    }
}
