package com.bezkoder.springjwt.Services;

import com.bezkoder.springjwt.models.Bus;
import com.bezkoder.springjwt.repository.BusRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class BusService implements IBus{


    BusRepo busrepo;
    @Override
    public Bus addBus(Bus b) {
        return busrepo.save(b);
    }

    @Override
    public Bus updateBus(Long id, Bus b) {
        Bus bus = busrepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("bus with id " + id + " not found"));

        bus.setCapacite(b.getCapacite());
        bus.setTypeB(b.getTypeB());

        return busrepo.save(bus);    }


    @Override
    public Bus retrieveBusById(Long id) {
        return busrepo.findById(id).orElse(null);
    }

    @Override
    public List<Bus> retrieveAllBus() {
        return busrepo.findAll();
    }

    @Override
    public void deleteBus(Long id)  {
        busrepo.deleteById(id);

    }
}
