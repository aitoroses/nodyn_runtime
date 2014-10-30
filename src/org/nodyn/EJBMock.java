package org.nodyn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grayfox on 29/10/14.
 */
public class EJBMock {

    private class Ticket {
        public int getTicketId() {
            return this.hashCode();
        }
    }

    public List<Ticket> fetchAllTickets() {
        List l = new ArrayList<Ticket>();
        for (int i = 0; i < 10; i++) {
            l.add(new Ticket());
        }
        return l;
    }
}
